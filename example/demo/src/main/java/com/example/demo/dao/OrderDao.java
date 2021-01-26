package com.example.demo.dao;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderDao {

    /**
     * 列出订单列表
     *
     * @return orderList
     */
    List<Order> queryOrder();

    /**
     * 根据Id列出具体订单
     *
     * @return Order
     */
    Order queryOrderById(int orderId);

    /**
     * 插入订单信息
     *
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 更新订单信息
     *
     * @param order
     * @return
     */
    int updateOrder(Order order);

    /**
     * 删除订单信息
     *
     * @param orderId
     * @return
     */
    int deleteOrder(int orderId);
}
