package com.example.demo.service.impl;

import com.example.demo.dao.RecruitDao;
import com.example.demo.entity.Recruit;
import com.example.demo.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;

    @Override
    public List<Recruit> getRecruitList() {
        return recruitDao.queryRecruit();
    }

    @Override
    public Recruit getRecruitById(int recruitId) {
        return recruitDao.queryRecruitById(recruitId);
    }

    @Transactional
    @Override
    public boolean addRecruit(@RequestBody Recruit recruit) {
        if(recruit.getRecruitId() == null && !"".equals(recruit.getRecruitId()) ){
            try{
                int effectedNum = recruitDao.insertRecruit(recruit);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("添加招聘失败");
                }
            } catch (Exception e){
                throw new RuntimeException("添加招聘失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("1招聘信息不能为空"));
        }
    }

    @Override
    public boolean modifyRecruit(Recruit recruit) {
        if(recruit.getRecruitId() != null && (recruit.getRecruitId()) > 0 ){
            try{
                int effectedNum = recruitDao.updateRecruit(recruit);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("更新招聘信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("更新招聘信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("招聘信息不能为空"));
        }
    }

    @Override
    public boolean deleteRecruit(int recruitId) {
        if(recruitId > 0 ){
            try{
                int effectedNum = recruitDao.deleteRecruit(recruitId);
                if(effectedNum > 0){
                    return true;
                } else{
                    throw new RuntimeException("删除招聘信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("删除招聘信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException(("招聘Id不能为空"));
        }
    }
}
