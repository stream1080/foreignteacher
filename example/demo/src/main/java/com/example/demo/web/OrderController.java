package com.example.demo.web;

import com.example.demo.entity.Order;

import com.example.demo.service.OrderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/listorder",method = RequestMethod.GET)
    private Map<String,Object> listOrder(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Order> list = orderService.getOrderList();
        modelMap.put("orderList",list);
        return modelMap;
    }


    /**
     * 通过订单Id获取订单信息
     *
     * @return
     */
    @RequestMapping(value = "/getorderbyid", method = RequestMethod.GET)
    private Map<String, Object> getOrderById(Integer orderId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取订单信息
        Order order = orderService.getOrderById(orderId);
        modelMap.put("order", order);
        return modelMap;
    }


    /**
     * 添加订单信息
     *
     * @param orderStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    private Map<String, Object> addOrder(@RequestBody Order order)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加订单信息
        modelMap.put("success", orderService.addOrder(order));
        return modelMap;
    }


    /**
     * 修改订单信息，主要修改名字
     *
     * @param orderStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyorder", method = RequestMethod.POST)
    private Map<String, Object> modifyOrder(@RequestBody Order order)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改订单信息
        modelMap.put("success", orderService.modifyOrder(order));
        return modelMap;
    }

    @RequestMapping(value = "/removeorder", method = RequestMethod.GET)
    private Map<String, Object> removeOrder(Integer orderId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改订单信息
        modelMap.put("success", orderService.deleteOrder(orderId));
        return modelMap;
    }

}
