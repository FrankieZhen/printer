package com.xcz.printer.service.impl;

import com.xcz.printer.dao.UserDao;
import com.xcz.printer.pojo.Address;
import com.xcz.printer.pojo.User;
import com.xcz.printer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectByOpenId(String openId) {
        return userDao.getUserByopenId(openId);
    }

    @Override
    public boolean addUser(User user, String openId) {
        String nickname = user.getNickname();
        Integer gender = user.getGender();
        String avatarurl = user.getAvatarurl();
        String language = user.getLanguage();
        String city = user.getCity();
        String province = user.getProvince();
        String country = user.getCountry();

        return userDao.addUser(openId,nickname,gender,avatarurl,language,city,province,country);
    }

    @Override
    public List<Address> getAddressList(int userId) {
        return userDao.getAddressList(userId);
    }

    @Override
    public boolean modifyAddress(int id, int userId, String recName, String recPhone, String recAddress , int isSelect) {
        return userDao.modifyAddress(id,userId,recName,recPhone,recAddress ,isSelect);
    }

    @Override
    public boolean addAddress(int userId, String recName, String recPhone, String recAddress,int isSelect) {
        return userDao.addAddress(userId,recName,recPhone,recAddress,isSelect);
    }

    @Override
    public boolean delAddress(int addressId) {
        return userDao.delAddress(addressId);
    }

    @Override
    public Address checkAndGetId(int userId) {
        return userDao.checkAndGetId(userId);
    }

    @Override
    public void changeUnSelect(int id) {
        userDao.changeUnSelect(id);
    }
}
