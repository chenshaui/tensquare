package com.tensquare.gather.dao;

import com.tensquare.gather.pojo.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author chenshuai
 */
@Repository
public interface GatheringDao extends JpaRepository<Gathering, String>, JpaSpecificationExecutor<Gathering> {
}
