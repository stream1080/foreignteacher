package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderService {

    /**
     * 获取订单列表
     *
     * @return
     */
    List<Order> getOrderList();

    /**
     * 通过订单Id获取订单信息
     *
     * @param orderId
     * @return
     */
    Order getOrderById(int orderId);

    /**
     * 增加订单信息
     *
     * @param order
     * @return
     */
    boolean addOrder(Order order);

    /**
     * 修改订单信息
     *
     * @param order
     * @return
     */
    boolean modifyOrder(Order order);

    /**
     * 删除订单信息
     *
     * @param orderId
     * @return
     */
    boolean deleteOrder(int orderId);
}
