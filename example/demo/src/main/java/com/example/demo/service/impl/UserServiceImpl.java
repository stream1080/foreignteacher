package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.queryUser();
    }

    @Override
    public User getUserById(int userId) {
        return userDao.queryUserById(userId);
    }


    @Transactional
    @Override
    public boolean addUser(@RequestBody User user) {
       if(user.getUserId() == null && !"".equals(user.getUserId()) ){
            try{
                int effectedNum = userDao.insertUser(user);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("添加用户失败");
                }
            } catch (Exception e){
                throw new RuntimeException("添加用户失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("1用户信息不能为空"));
        }
    }

    @Override
    public boolean modifyUser(User user) {
        if(user.getUserId() != null && (user.getUserId()) > 0 ){
            try{
                int effectedNum = userDao.updateUser(user);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("更新用户信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("更新用户信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("用户信息不能为空"));
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        if(userId > 0 ){
            try{
                int effectedNum = userDao.deleteUser(userId);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("删除用户信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("删除用户信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("用户Id不能为空"));
        }
    }


    @Override//微信小程序登录验证
    public User wxlogin(@RequestBody User user) {
        return userDao.wxlogin(user);
    }
}
