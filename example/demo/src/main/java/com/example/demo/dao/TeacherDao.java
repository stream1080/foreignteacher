package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;

import java.util.List;

public interface TeacherDao {

    /**
     * 列出用户列表
     *
     * @return teacherList
     */
    List<Teacher> queryTeacher();

    /**
     * 根据Id列出具体用户
     *
     * @return Teacher
     */
    Teacher queryTeacherById(int teacherId);

    /**
     * 插入用户信息
     *
     * @param teacher
     * @return
     */
    int insertTeacher(Teacher teacher);

    /**
     * 更新用户信息
     *
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 删除用户信息
     *
     * @param teacherId
     * @return
     */
    int deleteTeacher(int teacherId);

    /**
     * 微信小程序登录验证
     *
     * @param teacher
     * @return
     */
    Teacher teacherlogin(Teacher teacher);
}
