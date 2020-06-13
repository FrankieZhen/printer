package com.xcz.printer.controller.wechat;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.xcz.printer.pojo.TbOrder;
import com.xcz.printer.pojo.UpLoadFileInfo;
import com.xcz.printer.service.OrderService;
import com.xcz.printer.utils.JSONResult;
import com.xcz.printer.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    String BaseDirPath = "D:/GitProjects/printerFiles";

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    @ResponseBody
    public JSONResult orderAdd(@RequestBody TbOrder orderInfo){
        int userId = orderInfo.getUserId();
        int shopId = orderInfo.getShopId();
        String recName = orderInfo.getRecName();
        String recPhone = orderInfo.getRecPhone();
        String recAddress = orderInfo.getRecAddress();
        int number = orderInfo.getNumber();
        String type = orderInfo.getType();
        BigDecimal price = orderInfo.getPrice();
        String fileName = orderInfo.getFileName();
        String file = orderInfo.getFile();
        int page = orderInfo.getPage();
        String deliver = orderInfo.getDeliver();
        String style = orderInfo.getStyle();

        if(orderService.addOrder(userId,shopId,recName,recPhone,recAddress,number,type,price,fileName,file, page,deliver,style)){
            return JSONResult.ok();
        }else return JSONResult.errorMsg("创建订单失败");

    }

    @RequestMapping("/list")
    @ResponseBody
    public JSONResult orderList(int userId){
        List<TbOrder> orderList = orderService.getOrderListByUserId(userId);
        String result = JsonUtils.objectToJson(orderList);
        return JSONResult.ok(result );
    }

    @GetMapping("/pay")
    @ResponseBody
    public JSONResult pay(int orderId){
        if(orderService.pay(orderId)) {
            return JSONResult.ok();
        }else return JSONResult.errorMsg("支付失败");
    }

    @GetMapping("/cancel")
    @ResponseBody
    public JSONResult cancel(int orderId){
        if(orderService.cancel(orderId)) {
            return JSONResult.ok();
        }else return JSONResult.errorMsg("取消订单失败");
    }

    @GetMapping("/end")
    @ResponseBody
    public JSONResult end(int orderId){
        if(orderService.end(orderId)) {
            return JSONResult.ok();
        }else return JSONResult.errorMsg("确认收货失败");
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public JSONResult fileUpload(HttpServletRequest request , HttpServletResponse response,
                                 @RequestParam(value = "file",required = false) MultipartFile file) throws Exception{
        String openId = request.getParameter("openId");
        String fileName = request.getParameter("fileName");
        String uploadPath = BaseDirPath + "/" + openId;   //真实保存的路径
        String savePath = "/upload/" + openId;       //数据库保存的相对路径（以文件夹开始）
        UpLoadFileInfo result = new UpLoadFileInfo();
        File dir = new File(uploadPath);
        if (!dir.exists()) {
            dir.mkdir();
        }

//        System.out.println(fileName);

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        PDDocument p = null;

        ActiveXComponent wordCom = null;

        try {
            if (file != null) {

                String tmpFileName = file.getOriginalFilename();  //此文件名为微信临时文件名 wx开头(带pdf、doc后缀)

                if (StringUtils.isNotBlank(tmpFileName)) {
//                    System.out.println(fileName);

                    uploadPath += ("/" + tmpFileName);   //最终保存的路径url(带pdf、doc后缀)
                    savePath += ("/" + tmpFileName);

                    result.setRealPath(savePath);

//                    System.out.println(uploadPath);
//                    coverPathDB = coverPathDB + "/" + fileNamePrefix + ".jpg";

                    File outFile = new File(uploadPath);
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);

                    if(fileName.contains(".pdf")){

                        p = PDDocument.load(outFile);
//                        PDFParser p = new PDFParser(new FileInputStream(uploadPath));
//                        p.parse();
//                        int page = p.getPDDocument().getNumberOfPages();
                        int page = p.getNumberOfPages();
                        System.out.println(page);
                        result.setPage(page);
                    }else if(fileName.contains(".doc")){

                        // 建立ActiveX部件
                        wordCom = new ActiveXComponent("Word.Application");
                        //word应用程序不可见
                        wordCom.setProperty("Visible", false);
                        // 返回wrdCom.Documents的Dispatch
                        Dispatch wrdDocs = wordCom.getProperty("Documents").toDispatch();//Documents表示word的所有文档窗口（word是多文档应用程序）
                        // 调用wrdCom.Documents.Open方法打开指定的word文档，返回wordDoc
                        Dispatch wordDoc = Dispatch.call(wrdDocs, "Open", uploadPath, false, true, false).toDispatch();
                        Dispatch selection = Dispatch.get(wordCom, "Selection").toDispatch();
                        int page = Integer.parseInt(Dispatch.call(selection,"information",4).toString());//总页数 //显示修订内容的最终状态
                        System.out.println(page);
                        result.setPage(page);

                        //关闭文档且不保存
                        Dispatch.call(wordDoc, "Close", new Variant(false));

                    }

                }

            } else {
                return JSONResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JSONResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            if(p!=null){
                p.close();
            }
            if(wordCom!=null){
                //退出进程对象
                wordCom.invoke("Quit", new Variant[] {});
            }
        }


        return JSONResult.ok(result);
    }
}

