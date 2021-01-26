package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 列出用户列表
     *
     * @return userList
     */
    List<User> queryUser();

    /**
     * 根据Id列出具体用户
     *
     * @return User
     */
    User queryUserById(int userId);

    /**
     * 插入用户信息
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    int deleteUser(int userId);


    /**
     * 微信小程序登录验证
     *
     * @param user
     * @return
     */
    User wxlogin(User user);
}
