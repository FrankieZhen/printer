package com.xcz.printer.dao;

import com.xcz.printer.pojo.Latlng;
import com.xcz.printer.pojo.MapInfo;
import com.xcz.printer.pojo.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopDao {

    @Select("select * from  shop")
    public List<Shop> getShopsList();

    @Select("select * from shop where id = #{shopId}")
    public Shop getShopById(@Param("shopId") int shopId);

    @Update("update shop set shop_name = #{shopName} , location = #{location} , iscolorful = #{iscolorful} where id = #{shopId}")
    Boolean updateNameAndLocation(@Param("shopId")int shopId ,@Param("shopName")String shopName,
                                  @Param("location")String shopLocation,@Param("iscolorful")int iscolorful);

    @Update("update shop set single_pure_price = #{singlePurePrice} , double_pure_price = #{doublePurePrice} ," +
            "single_color_price = #{singleColorPrice} , double_color_price = #{doubleColorPrice} ," +
            "deliver_price = #{deliverPrice} where id = #{shopId}")
    Boolean updatePrice(@Param("shopId")int shopId, @Param("singlePurePrice")Double singlePure,
                        @Param("doublePurePrice")Double doublePure, @Param("singleColorPrice")Double singleColor,
                        @Param("doubleColorPrice")Double doubleColor ,@Param("deliverPrice")Double deliver);

    @Update("update shop set lat = #{lat} , lng = #{lng}  where id = #{shopId}")
    Boolean updateLatLng(@Param("shopId")int shopId, @Param("lat")Double lat, @Param("lng")Double lng);

    @Select("select lat , lng from shop where id = #{shopId}")
    Latlng getLatLng(@Param("shopId")int shopId);


    @Insert("insert into shop (shop_name,location,iscolorful) values(#{shopName} ,#{location},#{iscolorful})")
    boolean addShop(@Param("shopName")String shopName, @Param("location")String shopLocation, @Param("iscolorful")int iscolorful);

    @Select("select max(id) from shop")
    int getNewShopId();

    @Select("select count(*) from shop where shop_name = #{shopName}")
    int checkShopName(@Param("shopName")String shopName);

    @Select("select id,shop_name,location,lat,lng from shop")
    List<MapInfo> getShopMapInfo();
}
