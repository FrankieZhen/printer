package com.xcz.printer.service.impl;

import com.xcz.printer.dao.AdminUserDao;
import com.xcz.printer.mapper.AdminUserMapper;
import com.xcz.printer.pojo.AdminUser;
import com.xcz.printer.service.AdminUserService;
import com.xcz.printer.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminUserDao adminUserDao;

    @Override
    public AdminUser login(String userName, String password) {
//        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserDao.login(userName, password);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserDao.selectById(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserDao.selectById(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
//            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
//            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            //比较原密码是否正确
            if (originalPassword.equals(adminUser.getLoginPassword())) {
                //设置新密码并修改
//                adminUser.setLoginPassword(newPassword);
                if (adminUserDao.updatePassword(newPassword,adminUser.getId())) {
                    //修改成功则返回true
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserDao.selectById(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新密码并修改
//            adminUser.setLoginName(loginUserName);
//            adminUser.setNickName(nickName);
            if (adminUserDao.updateLoginAndNickName(loginUserId,loginUserName,nickName)) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean regist(String loginName, String password) {
        return adminUserDao.regist(loginName,password);
    }

    @Override
    public AdminUser selectByLoginName(String loginName) {
        return adminUserDao.selectByLoginName(loginName);
    }

    @Override
    public boolean bindShopId(int userId, int shopId) {
        return adminUserDao.bindShopId(userId,shopId);
    }
}
