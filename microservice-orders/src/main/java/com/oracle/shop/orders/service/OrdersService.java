package com.oracle.shop.orders.service;

import com.oracle.shop.orders.po.Orders;
public interface OrdersService{


    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

}
