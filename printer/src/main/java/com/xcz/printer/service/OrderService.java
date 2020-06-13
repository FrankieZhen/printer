package com.xcz.printer.service;


import com.xcz.printer.pojo.TbOrder;
import com.xcz.printer.utils.PageQueryUtil;
import com.xcz.printer.utils.PageResult;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    PageResult getOrdersPage(PageQueryUtil pageUtil);

    PageResult getOrdersByShopId(PageQueryUtil pageUtil, int shopId);

    boolean finish(int id);

    boolean deliver(int id);

    boolean cancel(int id);

    List<TbOrder> getOrderList();

    boolean pay(int id);

    boolean end(int id);

    List<TbOrder> getOrderListByUserId(int userId);

    boolean addOrder(int userId, int shopId, String recName, String recPhone, String recAddress, int number, String type, BigDecimal price, String fileName, String file, int page, String deliver, String style);

    PageResult getOrdersWithKey(PageQueryUtil pageUtil, int shopId, String keyword);
}
