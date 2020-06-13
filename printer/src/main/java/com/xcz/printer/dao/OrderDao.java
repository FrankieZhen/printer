package com.xcz.printer.dao;

import com.xcz.printer.pojo.TbOrder;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Mapper
public interface OrderDao {

    @Select("select * from  tb_order ORDER BY id desc")
    public List<TbOrder> getOrderList();

    @Select("select count(*) from  tb_order")
    public int getOrderTotal();

    @Select("select * from  tb_order where shop_id = #{shopId} order by id desc")
    List<TbOrder> getOrderListByShopId(@Param("shopId")int shopId);

    @Select("select count(*) from  tb_order where shop_id = #{shopId}")
    int getOrderTotalByShopId(@Param("shopId")int shopId);

    @Update("update tb_order set status = '已打印' , finish_time = #{date} where id = #{id}")
    boolean finish(@Param("id")int id, @Param("date")Date date);

    @Update("update tb_order set status = '已发货' , latest_time = #{date} where id = #{id}")
    boolean deliver(@Param("id")int id,@Param("date")Date date);

    @Update("update tb_order set status = '已取消' ,finish_time = #{date} , latest_time = null where id = #{id}")
    boolean cancel(@Param("id")int id,@Param("date")Date date);

    @Update("update tb_order set status = '已付款' ,latest_time = #{date} where id = #{id}")
    boolean pay(@Param("id")int id,@Param("date")Date date);

    @Update("update tb_order set status = '已完成' ,finish_time = #{date} , latest_time = null where id = #{id}")
    boolean end(@Param("id")int id,@Param("date")Date date);

    @Select("select * from  tb_order where user_id = #{userId} ORDER BY id desc" )
    List<TbOrder> getOrderListByUserId(@Param("userId")int userId);

    @Insert("insert into tb_order (user_id, shop_id,rec_phone,rec_name,rec_address,number,type,price," +
            "file_name,file,page,deliver,style,status,create_time) VALUES (#{userId}, #{shopId},#{recPhone}," +
            "#{recName},#{recAddress},#{number},#{type},#{price},#{fileName},#{file}," +
            "#{page},#{deliver},#{style},'未付款',#{date})")
    boolean addOrder(@Param("userId")int userId, @Param("shopId")int shopId, @Param("recName")String recName,
                     @Param("recPhone")String recPhone, @Param("recAddress")String recAddress, @Param("number")int number,
                     @Param("type")String type, @Param("price")BigDecimal price, @Param("fileName")String fileName,
                     @Param("file")String file, @Param("page")int page, @Param("deliver")String deliver,
                     @Param("style")String style, @Param("date")Date date);

    @Select("select * from  tb_order where shop_id = #{shopId} and rec_name like '%${keyword}%' " +
            "or rec_phone like '%${keyword}%' ORDER BY id desc limit #{start},#{limit}" )
    List<TbOrder> getOrderListWithKey(@Param("shopId")int shopId, @Param("keyword")String keyword,@Param("start")int start, @Param("limit")int limit);

    @Select("select count(*) from  tb_order where shop_id = #{shopId} and rec_name like '%${keyword}%'" +
            "or rec_phone like '%${keyword}%'")
    int getOrderTotalWithKey(@Param("shopId")int shopId,@Param("keyword") String keyword);

    @Select("select * from  tb_order where shop_id = #{shopId} order by id desc limit #{start},#{limit}")
    List<TbOrder> getOrderListByPage(@Param("shopId")int shopId, @Param("start")int start, @Param("limit")int limit);
}
