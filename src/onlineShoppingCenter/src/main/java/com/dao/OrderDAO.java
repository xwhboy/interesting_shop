package com.dao;

import com.entity.Order;

import java.util.List;

/**
 * Created by ZK on 6/26/16.
 */
public interface OrderDAO {
    Order getOrderById(int id);
    // Order gerOrderByUserName(int pagesize,int pagenum,String username );
    List<Order> getOrderByKeyWord(int pagesize, int pagenum, String OrderNum, int Orderstatus, String userAccount);
    int saveOrder(Order order);
    boolean delOrder(Order order);
    boolean updateOrder(Order order);
}
