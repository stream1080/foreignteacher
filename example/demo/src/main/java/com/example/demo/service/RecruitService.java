package com.example.demo.service;

import com.example.demo.entity.Recruit;

import java.util.List;

public interface RecruitService {

    /**
     * 获取招聘列表
     *
     * @return
     */
    List<Recruit> getRecruitList();

    /**
     * 通过招聘Id获取招聘信息
     *
     * @param recruitId
     * @return
     */
    Recruit getRecruitById(int recruitId);

    /**
     * 增加招聘信息
     *
     * @param recruit
     * @return
     */
    boolean addRecruit(Recruit recruit);

    /**
     * 修改招聘信息
     *
     * @param recruit
     * @return
     */
    boolean modifyRecruit(Recruit recruit);

    /**
     * 删除招聘信息
     *
     * @param recruitId
     * @return
     */
    boolean deleteRecruit(int recruitId);
}
