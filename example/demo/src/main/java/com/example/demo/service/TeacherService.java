package com.example.demo.service;

import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     * 获取外教列表
     *
     * @return
     */
    List<Teacher> getTeacherList();

    /**
     * 通过外教Id获取外教信息
     *
     * @param teacherId
     * @return
     */
    Teacher getTeacherById(int teacherId);

    /**
     * 增加外教信息
     *
     * @param teacher
     * @return
     */
    boolean addTeacher(Teacher teacher);

    /**
     * 修改外教信息
     *
     * @param teacher
     * @return
     */
    boolean modifyTeacher(Teacher teacher);

    /**
     * 删除外教信息
     *
     * @param teacherId
     * @return
     */
    boolean deleteTeacher(int teacherId);

    /**
     * 微信小程序登录验证
     *
     * @param teacher
     * @return
     */
    Teacher teacherlogin(Teacher teacher);
}
