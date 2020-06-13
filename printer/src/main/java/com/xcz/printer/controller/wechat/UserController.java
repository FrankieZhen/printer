package com.xcz.printer.controller.wechat;

import com.alibaba.fastjson.JSONObject;
import com.xcz.printer.pojo.Address;
import com.xcz.printer.pojo.User;
import com.xcz.printer.service.UserService;
import com.xcz.printer.utils.AesUtil;
import com.xcz.printer.utils.HttpRequest;
import com.xcz.printer.utils.JSONResult;
import com.xcz.printer.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/query")
    @ResponseBody
    public JSONResult queryShop(@RequestBody User user , String openId){
        User result = userService.selectByOpenId(openId);
        if(result == null){
            if(userService.addUser(user,openId)){
                return JSONResult.ok(userService.selectByOpenId(openId));
            }else return JSONResult.errorMsg("新增用户失败");
        }
        return JSONResult.ok(result);
    }

    @RequestMapping("/address")
    @ResponseBody
    public JSONResult addressList(int userId){
        List<Address> addressList = userService.getAddressList(userId);
        String result = JsonUtils.objectToJson(addressList);
        return JSONResult.ok(result );
    }

    @GetMapping("/delAddress")
    @ResponseBody
    public JSONResult delAddress(int addressId){
        if(userService.delAddress(addressId)) {
            return JSONResult.ok();
        }else return JSONResult.errorMsg("删除失败");
    }

    @GetMapping("/getSelectAddress")
    @ResponseBody
    public JSONResult getSelectAddress(int userId){
        Address result = userService.checkAndGetId(userId);
        if(result!= null) {
            return JSONResult.ok();
        }else return JSONResult.errorMsg("获取收货信息失败");
    }

    @RequestMapping("/address/modify")
    @ResponseBody
    public JSONResult addressModify(@RequestBody Address address){
        int id = address.getId();
        int userId = address.getUserId();
        String recName = address.getRecName();
        String recPhone = address.getRecPhone();
        String recAddress = address.getRecAddress();
        int isSelect = address.getIsselected();
        if(isSelect ==1){
            Address result = userService.checkAndGetId(userId); //查看当前用户默认 select = 1 的其他地址
            if(result!=null){
                userService.changeUnSelect(result.getId());  //将查到的地址设为select = 0
            }
        }
        //当前操作的地址就变为 select=1，设为默认了
        if(userService.modifyAddress(id,userId,recName,recPhone,recAddress,isSelect)){
            return JSONResult.ok();
        }else return JSONResult.errorMsg("修改地址失败");

    }

    @RequestMapping("/address/add")
    @ResponseBody
    public JSONResult addressAdd(@RequestBody Address address){

        int userId = address.getUserId();
        String recName = address.getRecName();
        String recPhone = address.getRecPhone();
        String recAddress = address.getRecAddress();
        int isSelect = address.getIsselected();
        if(isSelect ==1){
            Address result = userService.checkAndGetId(userId); //查看当前用户默认 select = 1 的其他地址
            if(result!=null){
                userService.changeUnSelect(result.getId());  //将查到的地址设为select = 0
            }
        }
        //新增的地址就变为 select=1，设为默认了
        if(userService.addAddress(userId,recName,recPhone,recAddress,isSelect)){
            return JSONResult.ok();
        }else return JSONResult.errorMsg("新增地址失败");
    }



    @ResponseBody
    @RequestMapping(value = "/getOpenid", method = RequestMethod.GET)
    public Map getOpenid(String code, String encryptedData, String iv ) throws Exception{

        Map<String,Object> map = new HashMap<String,Object>();
        //code = "081ZExyD0qnP4j2LV5yD0hFLyD0ZExyK";
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            System.out.println("map1:" + map);
            return map;
        }
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wx9c3623915a9f88f9";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "4b74f6b6d219134ae349db74240c5949";
        //授权（必填）
        String grant_type = "authorization_code";
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        System.out.println("openid:" + openid);
        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                JSONObject userInfoJSON = JSONObject.parseObject(result);
                Map<String,Object> userInfo = new HashMap<String,Object>();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                System.out.println("map2:" + map);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        System.out.println("map3:" + map);
        return map;
    }



}
