package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenshuai
 */
@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 根据状态查询
     * @param state 状态
     * @return java.util.List<com.tensquare.recruit.pojo.Recruit>
     * @throws Exception
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state) {
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    /**
     * 最新职位列表
     * @return java.util.List<com.tensquare.recruit.pojo.Recruit>
     */
    public List<Recruit> newlist(){
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }
}
