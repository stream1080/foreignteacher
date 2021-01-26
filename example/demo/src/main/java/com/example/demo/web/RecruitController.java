package com.example.demo.web;

import com.example.demo.entity.Recruit;

import com.example.demo.service.RecruitService;
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
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    @RequestMapping(value="/listrecruit",method = RequestMethod.GET)
    private Map<String,Object> listRecruit(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Recruit> list = recruitService.getRecruitList();
        modelMap.put("recruitList",list);
        return modelMap;
    }


    /**
     * 通过招聘Id获取招聘信息
     *
     * @return
     */
    @RequestMapping(value = "/getrecruitbyid", method = RequestMethod.GET)
    private Map<String, Object> getRecruitById(Integer recruitId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取招聘信息
        Recruit recruit = recruitService.getRecruitById(recruitId);
        modelMap.put("recruit", recruit);
        return modelMap;
    }


    /**
     * 添加招聘信息
     *
     * @param recruitStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addrecruit", method = RequestMethod.POST)
    private Map<String,Object> addRecruit(@RequestBody Recruit recruit)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加招聘信息
        modelMap.put("success", recruitService.addRecruit(recruit));
        return modelMap;
    }


    /**
     * 修改招聘信息，主要修改名字
     *
     * @param recruitStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyrecruit", method = RequestMethod.POST)
    private Map<String, Object> modifyRecruit(@RequestBody Recruit recruit)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改招聘信息
        modelMap.put("success", recruitService.modifyRecruit(recruit));
        return modelMap;
    }

    @RequestMapping(value = "/removerecruit", method = RequestMethod.GET)
    private Map<String, Object> removeRecruit(Integer recruitId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改招聘信息
        modelMap.put("success", recruitService.deleteRecruit(recruitId));
        return modelMap;
    }

}
