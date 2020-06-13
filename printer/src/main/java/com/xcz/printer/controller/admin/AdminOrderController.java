package com.xcz.printer.controller.admin;

import com.xcz.printer.service.OrderService;
import com.xcz.printer.utils.PageQueryUtil;
import com.xcz.printer.utils.Result;
import com.xcz.printer.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String show(HttpServletRequest request) {
        request.setAttribute("path", "order");
        return "admin/blog";
    }

    @GetMapping("/order/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params,HttpServletRequest request) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        int shopId = (Integer) request.getSession().getAttribute("shopId");
        return ResultGenerator.genSuccessResult(orderService.getOrdersByShopId(pageUtil,shopId));
    }


    @GetMapping("/order/listWithKey")
    @ResponseBody
    public Result listWithKey(@RequestParam Map<String, Object> params,HttpServletRequest request) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String keyword = (String)params.get("keyword");

        PageQueryUtil pageUtil = new PageQueryUtil(params);
        int shopId = (Integer) request.getSession().getAttribute("shopId");
        return ResultGenerator.genSuccessResult(orderService.getOrdersWithKey(pageUtil,shopId,keyword));
    }



    @PostMapping("/order/finish")
    @ResponseBody
    public Result finish(@RequestBody List<Integer> ids) {

        for(int i=0;i<ids.size();i++){
            if(!orderService.finish(ids.get(i))){
                ResultGenerator.genFailResult("修改失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/order/deliver")
    @ResponseBody
    public Result deliver(@RequestBody List<Integer> ids) {

        for(int i=0;i<ids.size();i++){
            if(!orderService.deliver(ids.get(i))){
                ResultGenerator.genFailResult("修改失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/order/cancel")
    @ResponseBody
    public Result cancel(@RequestBody List<Integer> ids) {

        for(int i=0;i<ids.size();i++){
            if(!orderService.cancel(ids.get(i))){
                ResultGenerator.genFailResult("修改失败");
            }
        }
        return ResultGenerator.genSuccessResult();
    }
}
