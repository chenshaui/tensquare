package com.tensquare.use.dao;

import com.tensquare.use.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * @author chenshuai
 */
@Repository
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    User findByMobile(String mobile);
}
