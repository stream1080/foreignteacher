package com.example.demo.web;

import com.example.demo.entity.User;

import com.example.demo.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/listuser",method = RequestMethod.GET)
    private Map<String,Object> listUser(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<User> list = userService.getUserList();
        modelMap.put("userList",list);
        return modelMap;
    }


    /**
     * 通过用户Id获取用户信息
     *
     * @return
     */
    @RequestMapping(value = "/getuserbyid", method = RequestMethod.GET)
    private Map<String, Object> getUserById(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取用户信息
        User user = userService.getUserById(userId);
        modelMap.put("user", user);
        return modelMap;
    }


    /**
     * 添加用户信息
     *
     * @param userStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    private Map<String,Object> addUser(@RequestBody User user)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加用户信息
        modelMap.put("success", userService.addUser(user));
        return modelMap;
    }


    /**
     * 修改用户信息，主要修改名字
     *
     * @param userStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
    private Map<String, Object> modifyUser(@RequestBody User user)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改用户信息
        modelMap.put("success", userService.modifyUser(user));
        return modelMap;
    }

    @RequestMapping(value = "/removeuser", method = RequestMethod.GET)
    private Map<String, Object> removeUser(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改用户信息
        modelMap.put("success", userService.deleteUser(userId));
        return modelMap;
    }

    @RequestMapping(value = "/wxlogin", method = RequestMethod.POST)
    private Map<String, Object> wxlogin(@RequestBody User user)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改用户信息

        modelMap.put("user", userService.wxlogin(user));
        return modelMap;
    }




}
