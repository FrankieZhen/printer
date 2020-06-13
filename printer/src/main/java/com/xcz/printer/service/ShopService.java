package com.xcz.printer.service;

import com.xcz.printer.pojo.Latlng;
import com.xcz.printer.pojo.MapInfo;
import com.xcz.printer.pojo.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> getShopsList();

    Shop getShopById(Integer shopId);

    Boolean updateNameAndLocation(int shopId,String shopName, String shopLocation,int iscolorful);

    Boolean updatePrice(int shopId, Double singlePure, Double doublePure, Double singleColor, Double doubleColor,Double deliver);

    Boolean updateLatLng(int shopId, Double lat, Double lng);

    Latlng getLatLng(int shopId);

    boolean addShop(String shopName, String shopLocation, int iscolorful);

    int getNewShopId();

    int checkShopName(String shopName);

    List<MapInfo> getShopMapInfo();
}
