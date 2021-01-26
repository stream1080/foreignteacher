package com.example.demo.dao;

import com.example.demo.entity.Recruit;

import java.util.List;

public interface RecruitDao {

    /**
     * 列出招聘列表
     *
     * @return recruitList
     */
    List<Recruit> queryRecruit();

    /**
     * 根据Id列出具体招聘信息
     *
     * @return Recruit
     */
    Recruit queryRecruitById(int recruitId);

    /**
     * 插入招聘信息
     *
     * @param recruit
     * @return
     */
    int insertRecruit(Recruit recruit);

    /**
     * 更新招聘信息
     *
     * @param recruit
     * @return
     */
    int updateRecruit(Recruit recruit);

    /**
     * 删除招聘信息
     *
     * @param recruitId
     * @return
     */
    int deleteRecruit(int recruitId);
}
