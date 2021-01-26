package com.example.demo.service.impl;

import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.Teacher;

import com.example.demo.entity.User;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDao.queryTeacher();
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.queryTeacherById(teacherId);
    }

    @Transactional
    @Override
    public boolean addTeacher(Teacher teacher) {
        if(teacher.getTeacherId() == null && !"".equals(teacher.getTeacherId())){
            try{
                int effectedNum = teacherDao.insertTeacher(teacher);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("添加用户失败");
                }
            } catch (Exception e){
                throw new RuntimeException("添加用户失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("用户信息不能为空"));
        }
    }

    @Override
    public boolean modifyTeacher(Teacher teacher) {
        if(teacher.getTeacherId() != null && (teacher.getTeacherId()) > 0 ){
            try{
                int effectedNum = teacherDao.updateTeacher(teacher);
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
    public boolean deleteTeacher(int teacherId) {
        if(teacherId > 0 ){
            try{
                int effectedNum = teacherDao.deleteTeacher(teacherId);
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
    public Teacher teacherlogin(@RequestBody Teacher teacher) {
        return teacherDao.teacherlogin(teacher);
    }
}