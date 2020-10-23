package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenshuai
 */
@Repository
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

    /**根据热门状态获取企业列表
     * @param ishot 是否热门
     * @return List<Enterprise>
     */
    List<Enterprise> findByIshot(String ishot);
}
