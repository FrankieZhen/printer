package com.xcz.printer.dao;

import com.xcz.printer.pojo.AdminUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminUserDao {

    @Select("select * from  admin_user where login_name = #{userName} and login_password=#{password}")
    public AdminUser login(@Param("userName")String userName, @Param("password")String password);

    @Insert("insert into admin_user (login_name, login_password) VALUES (#{userName}, #{password})")
    public boolean regist(@Param("userName")String userName, @Param("password")String password);

    @Select("select * from admin_user where login_name = #{loginName}")
    AdminUser selectByLoginName(@Param("loginName")String loginName);

    @Select("select * from admin_user where id = #{id}")
    AdminUser selectById(@Param("id")Integer loginUserId);


    @Update("update admin_user set login_password =#{password} where id = #{id}")
    boolean updatePassword(@Param("password")String password,@Param("id")Integer loginUserId);


    @Update("update admin_user set login_name =#{loginName} , nick_name =#{nickName} where id = #{id}")
    boolean updateLoginAndNickName(@Param("id")Integer loginUserId,@Param("loginName")String loginName,@Param("nickName")String nickName);

    @Update("update admin_user set shop_id =#{shopId} where id = #{userId}")
    boolean bindShopId(@Param("userId")int userId, @Param("shopId")int shopId);
}