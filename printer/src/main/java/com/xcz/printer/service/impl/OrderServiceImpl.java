package com.xcz.printer.service.impl;

import com.xcz.printer.dao.OrderDao;
import com.xcz.printer.pojo.TbOrder;
import com.xcz.printer.service.OrderService;
import com.xcz.printer.utils.PageQueryUtil;
import com.xcz.printer.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public PageResult getOrdersPage(PageQueryUtil pageUtil) {
        List<TbOrder> blogList = orderDao.getOrderList();
        int total = orderDao.getOrderTotal();
        PageResult pageResult = new PageResult(blogList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }



    @Override
    public PageResult getOrdersByShopId(PageQueryUtil pageUtil, int shopId) {
        int page = pageUtil.getPage();
        int limit = pageUtil.getLimit();
        int start = page == 1? 0 : (page-1)*limit;
        List<TbOrder> orderList = orderDao.getOrderListByPage(shopId,start,limit);
        int total = orderDao.getOrderTotalByShopId(shopId);
        PageResult pageResult = new PageResult(orderList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public boolean finish(int id) {
        return orderDao.finish(id,new Date());
    }

    @Override
    public boolean deliver(int id) {
        return orderDao.deliver(id,new Date());
    }

    @Override
    public boolean cancel(int id) {
        return orderDao.cancel(id,new Date());
    }

    @Override
    public List<TbOrder> getOrderList() {
        return orderDao.getOrderList();
    }

    @Override
    public boolean pay(int id) {
        return orderDao.pay(id,new Date());
    }

    @Override
    public boolean end(int id) {
        return orderDao.end(id,new Date());
    }

    @Override
    public List<TbOrder> getOrderListByUserId(int userId) {
        return orderDao.getOrderListByUserId(userId);
    }

    @Override
    public boolean addOrder(int userId, int shopId, String recName, String recPhone, String recAddress, int number, String type, BigDecimal price, String fileName, String file, int page, String deliver, String style) {
        return orderDao.addOrder(userId,shopId,recName,recPhone,recAddress,number,type,price,fileName,file, page,deliver,style,new Date());
    }

    @Override
    public PageResult getOrdersWithKey(PageQueryUtil pageUtil, int shopId, String keyword) {
        int page = pageUtil.getPage();
        int limit = pageUtil.getLimit();
        int start = page == 1? 0 : (page-1)*limit;
        List<TbOrder> orderList = orderDao.getOrderListWithKey(shopId,keyword,start,limit);
        int total = orderDao.getOrderTotalWithKey(shopId,keyword);
        PageResult pageResult = new PageResult(orderList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }
}
