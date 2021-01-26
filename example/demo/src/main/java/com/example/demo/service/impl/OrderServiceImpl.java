package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrderList() {
        return orderDao.queryOrder();
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDao.queryOrderById(orderId);
    }

    @Transactional
    @Override
    public boolean addOrder(Order order) {
        if(order.getOrderId() != null && !"".equals(order.getOrderId())){
            try{
                int effectedNum = orderDao.insertOrder(order);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("添加订单失败");
                }
            } catch (Exception e){
                throw new RuntimeException("添加订单失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("订单信息不能为空"));
        }
    }

    @Override
    public boolean modifyOrder(Order order) {
        if(order.getOrderId() != null && (order.getOrderId()) > 0 ){
            try{
                int effectedNum = orderDao.updateOrder(order);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("更新订单信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("更新订单信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("订单信息不能为空"));
        }
    }

    @Override
    public boolean deleteOrder(int orderId) {
        if(orderId > 0 ){
            try{
                int effectedNum = orderDao.deleteOrder(orderId);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("删除订单信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("删除订单信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("订单Id不能为空"));
        }
    }
}
