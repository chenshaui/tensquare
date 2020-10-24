package com.tensquare.use.dao;

import com.tensquare.use.pojo.Admin;
import com.tensquare.use.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author chenshuai
 */
@Repository
public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
    Admin findByLoginname(String loginname);
}
