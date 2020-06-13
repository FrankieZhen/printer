package com.xcz.printer.service;

import com.xcz.printer.pojo.Address;
import com.xcz.printer.pojo.User;

import java.util.List;

public interface UserService {

    User selectByOpenId(String openId);

    boolean addUser(User user, String openId);

    List<Address> getAddressList(int userId);

    boolean modifyAddress(int id, int userId, String recName, String recPhone, String recAddress ,int isSelect);

    boolean addAddress(int userId, String recName, String recPhone, String recAddress,int isSelect);

    boolean delAddress(int addressId);

    Address checkAndGetId(int userId);

    void changeUnSelect(int id);
}
