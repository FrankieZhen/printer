package com.xcz.printer.dao;

import com.xcz.printer.pojo.Address;
import com.xcz.printer.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user where openid = #{openId}")
    public User getUserByopenId(@Param("openId") String openId);


    @Insert("insert into user (openid,nickname,gender,avatarurl,language,city,province,country) " +
            "values(#{openId},#{nickname},#{gender},#{avatarurl},#{language},#{city}" +
            ",#{province},#{country})")
    boolean addUser(@Param("openId")String openId, @Param("nickname")String nickname, @Param("gender")Integer gender,
                    @Param("avatarurl")String avatarurl,@Param("language")String language,@Param("city")String city,
                    @Param("province")String province, @Param("country")String country);

    @Select("select * from address where user_id = #{userId}")
    List<Address> getAddressList(@Param("userId")int userId);

    @Update("update address set user_id = #{userId} , rec_name = #{recName} , rec_phone = #{recPhone}, " +
            "rec_address = #{recAddress} , isselected = #{isSelect} where id = #{id}")
    boolean modifyAddress(@Param("id")int id, @Param("userId")int userId, @Param("recName")String recName,
                          @Param("recPhone")String recPhone, @Param("recAddress")String recAddress ,
                          @Param("isSelect")int isSelect);

    @Insert("insert into address (user_id,rec_name,rec_phone,rec_address,isselected) " +
            "values(#{userId},#{recName},#{recPhone},#{recAddress},#{isSelect})")
    boolean addAddress(@Param("userId")int userId, @Param("recName")String recName,
                       @Param("recPhone")String recPhone, @Param("recAddress")String recAddress,
                       @Param("isSelect")int isSelect);

    @Delete("delete from address where id = #{addressId}")
    boolean delAddress(@Param("addressId")int addressId);

    @Select("select * from address where isselected = 1 and user_id = #{userId}")
    Address checkAndGetId(@Param("userId")int userId);

    @Update("update address set isselected = 0 where id = #{id}")
    void changeUnSelect(@Param("id")int id);
}
