package com.tensquare.gather.service;

import com.tensquare.gather.dao.GatheringDao;
import com.tensquare.gather.pojo.Gathering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @author chenshuai
 */
@Service
public class GatheringService {

    @Autowired
    private GatheringDao gatheringDao;

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    @Cacheable(value="gathing", key="#id")
    public Gathering findById(String id) {
        return gatheringDao.findById(id).get();
    }

    /**
     * 修改
     * @param gathering
     */
    @CacheEvict(value="gathering",key="#gathering.id")
    public void update(Gathering gathering) {
        gatheringDao.save(gathering);
    }
    /**
     * 删除
     * @param id
     */
    @CacheEvict(value="gathering",key="#id")
    public void deleteById(String id) {
        gatheringDao.deleteById(id);
    }
}
