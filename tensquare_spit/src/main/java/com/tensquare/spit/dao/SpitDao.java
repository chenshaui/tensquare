package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenshuai
 */
@Repository
public interface SpitDao extends MongoRepository<Spit, String> {
}
