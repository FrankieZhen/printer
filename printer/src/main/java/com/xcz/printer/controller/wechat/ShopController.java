package com.xcz.printer.controller.wechat;

import com.xcz.printer.pojo.MapInfo;
import com.xcz.printer.pojo.Shop;
import com.xcz.printer.service.ShopService;
import com.xcz.printer.utils.JSONResult;
import com.xcz.printer.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping("/list")
    @ResponseBody
    public JSONResult shopsList(){
        List<Shop> shopsList = shopService.getShopsList();
        String result = JsonUtils.objectToJson(shopsList);
        return JSONResult.ok(result );
    }

    @GetMapping("/query")
    @ResponseBody
    public JSONResult queryShop(int shopId){
        Shop shop = shopService.getShopById(shopId);
        String result = JsonUtils.objectToJson(shop);
        return JSONResult.ok(result );
    }

    @GetMapping("/map")
    @ResponseBody
    public JSONResult shopMap(){
        List<MapInfo> mapInfo = shopService.getShopMapInfo();
        String result = JsonUtils.objectToJson(mapInfo);
        return JSONResult.ok(result );
    }
}
