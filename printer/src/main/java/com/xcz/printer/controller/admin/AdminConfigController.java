package com.xcz.printer.controller.admin;

import com.xcz.printer.pojo.Shop;
import com.xcz.printer.service.AdminUserService;
import com.xcz.printer.service.ShopService;
import com.xcz.printer.utils.Result;
import com.xcz.printer.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminConfigController {

    int shopIdCache;

    @Resource
    private ShopService shopService;

    @Resource
    private AdminUserService adminUserService;

    @GetMapping("/configurations")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "configurations");
        Shop shopInfo = shopService.getShopById((Integer) request.getSession().getAttribute("shopId"));
        request.setAttribute("shopInfo",shopInfo);
        return "admin/configuration";
    }

    @GetMapping("/addShop")
    public String addShop(HttpServletRequest request) {
        request.setAttribute("path", "addShop");
        return "admin/addShop";
    }

    @PostMapping("/configurations/shopInfo")
    @ResponseBody
    public Result shopInfo(@RequestParam(value = "shopName", required = false) String shopName,
                          @RequestParam(value = "shopLocation", required = false) String shopLocation,
                          @RequestParam(value = "iscolorful", required = false) int iscolorful,
                          HttpServletRequest request) {

        int shopId = (Integer) request.getSession().getAttribute("shopId");
        if(shopService.checkShopName(shopName)> 0){
            return ResultGenerator.genFailResult("店铺名称已存在");
        }
        shopService.updateNameAndLocation(shopId,shopName,shopLocation,iscolorful);
        return  ResultGenerator.genSuccessResult();
    }

    @PostMapping("/configurations/price")
    @ResponseBody
    public Result price(@RequestParam(value = "singlePure", required = false) Double singlePure,
                          @RequestParam(value = "doublePure", required = false) Double doublePure,
                          @RequestParam(value = "singleColor", required = false) Double singleColor,
                          @RequestParam(value = "doubleColor", required = false) Double doubleColor,
                        @RequestParam(value = "deliver", required = false) Double deliver,
                          HttpServletRequest request) {

        int shopId;
        if(request.getSession().getAttribute("shopId")!= null){
            shopId = (Integer) request.getSession().getAttribute("shopId");
        }else {
            shopId = shopIdCache;
        }
        return  ResultGenerator.genSuccessResult(shopService.updatePrice(shopId,singlePure,doublePure,singleColor,doubleColor,deliver));
    }


    @PostMapping("/configurations/map")
    @ResponseBody
    public Result map(@RequestParam(value = "lat") Double lat,
                          @RequestParam(value = "lng") Double lng,
                          HttpServletRequest request) {
        int shopId;
        if(request.getSession().getAttribute("shopId")!= null){
            shopId = (Integer) request.getSession().getAttribute("shopId");
        }else {
            shopId = shopIdCache;
        }

        return  ResultGenerator.genSuccessResult(shopService.updateLatLng(shopId,lat,lng));
    }

    @GetMapping("/configurations/latlng")
    @ResponseBody
    public Result map(HttpServletRequest request) {

        int shopId = (Integer) request.getSession().getAttribute("shopId");
        return  ResultGenerator.genSuccessResult(shopService.getLatLng(shopId));
    }

    @PostMapping("/configurations/shopAdd")
    @ResponseBody
    public Result shopAdd(@RequestParam(value = "shopName", required = false) String shopName,
                           @RequestParam(value = "shopLocation", required = false) String shopLocation,
                           @RequestParam(value = "iscolorful", required = false) int iscolorful,
                           HttpServletRequest request) {

        if(shopService.checkShopName(shopName)> 0){
            return ResultGenerator.genFailResult("店铺名称已存在");
        }
        shopService.addShop(shopName,shopLocation,iscolorful);
        int shopId = shopService.getNewShopId();
        request.setAttribute("shopId",shopId);
        shopIdCache = shopId;
        int userId = (Integer)request.getSession().getAttribute("loginUserId");
        adminUserService.bindShopId(userId,shopId);
        return  ResultGenerator.genSuccessResult();

    }
}
