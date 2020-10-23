package com.tensquare.recruit.dao;


import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenshuai
 */
@Repository
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
    
    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @param state 状态
     * @return java.util.List<com.tensquare.recruit.pojo.Recruit>
     */
    List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 最新职位列表
     * @param state 状态
     * @return java.util.List<com.tensquare.recruit.pojo.Recruit>
     */
    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);

}
