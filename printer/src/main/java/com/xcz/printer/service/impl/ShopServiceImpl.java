package com.xcz.printer.service.impl;

import com.xcz.printer.dao.ShopDao;
import com.xcz.printer.pojo.Latlng;
import com.xcz.printer.pojo.MapInfo;
import com.xcz.printer.pojo.Shop;
import com.xcz.printer.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public List<Shop> getShopsList() {
        return shopDao.getShopsList();
    }

    @Override
    public Shop getShopById(Integer shopId) {
        return shopDao.getShopById(shopId);
    }

    @Override
    public Boolean updateNameAndLocation(int shopId ,String shopName, String shopLocation,int iscolorful) {
        return shopDao.updateNameAndLocation(shopId,shopName,shopLocation,iscolorful);
    }

    @Override
    public Boolean updatePrice(int shopId, Double singlePure, Double doublePure, Double singleColor, Double doubleColor,Double deliver) {
        return shopDao.updatePrice(shopId,singlePure,doublePure,singleColor,doubleColor,deliver);
    }

    @Override
    public Boolean updateLatLng(int shopId, Double lat, Double lng) {
        return shopDao.updateLatLng(shopId,lat,lng);
    }

    @Override
    public Latlng getLatLng(int shopId) {
        return shopDao.getLatLng(shopId);
    }

    @Override
    public boolean addShop(String shopName, String shopLocation, int iscolorful) {
        return shopDao.addShop(shopName,shopLocation,iscolorful);
    }

    @Override
    public int getNewShopId() {
        return shopDao.getNewShopId();
    }

    @Override
    public int checkShopName(String shopName) {
        return shopDao.checkShopName(shopName);
    }

    @Override
    public List<MapInfo> getShopMapInfo() {
        return shopDao.getShopMapInfo();
    }
}
