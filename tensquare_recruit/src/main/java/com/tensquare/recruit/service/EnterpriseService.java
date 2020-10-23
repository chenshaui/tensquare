package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenshuai
 */
@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * 热门企业列表
     * @return java.util.List<com.tensquare.recruit.pojo.Enterprise>
     */
    public List<Enterprise> hotlist(){
        return enterpriseDao.findByIshot("1");
    }
}
