package com.example.demo.web;

import com.example.demo.entity.Teacher;

import com.example.demo.entity.User;
import com.example.demo.service.TeacherService;

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
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value="/listteacher",method = RequestMethod.GET)
    private Map<String,Object> listTeacher(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Teacher> list = teacherService.getTeacherList();
        modelMap.put("teacherList",list);
        return modelMap;
    }


    /**
     * 通过用户Id获取用户信息
     *
     * @return
     */
    @RequestMapping(value = "/getteacherbyid", method = RequestMethod.GET)
    private Map<String, Object> getTeacherById(Integer teacherId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取用户信息
        Teacher teacher = teacherService.getTeacherById(teacherId);
        modelMap.put("teacher", teacher);
        return modelMap;
    }


    /**
     * 添加外教信息
     *
     * @param teacherStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addteacher", method = RequestMethod.POST)
    private Map<String, Object> addTeacher(@RequestBody Teacher teacher)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加外教信息
        modelMap.put("success", teacherService.addTeacher(teacher));
        return modelMap;
    }


    /**
     * 修改用户信息，主要修改名字
     *
     * @param teacherStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyteacher", method = RequestMethod.POST)
    private Map<String, Object> modifyTeacher(@RequestBody Teacher teacher)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改用户信息
        modelMap.put("success", teacherService.modifyTeacher(teacher));
        return modelMap;
    }

    @RequestMapping(value = "/removeteacher", method = RequestMethod.GET)
    private Map<String, Object> removeTeacher(Integer teacherId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改用户信息
        modelMap.put("success", teacherService.deleteTeacher(teacherId));
        return modelMap;
    }


    @RequestMapping(value = "/teacherlogin", method = RequestMethod.POST)
    private Map<String, Object> wxlogin(@RequestBody Teacher teacher)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改用户信息

        modelMap.put("user", teacherService.teacherlogin(teacher));
        return modelMap;
    }

}
