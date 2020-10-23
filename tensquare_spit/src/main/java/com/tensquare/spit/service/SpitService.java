package com.tensquare.spit.service;

import com.tensquare.base.utils.IdWorker;
import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;


import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chenshuai
 */
@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Spit> findAll(){
        return spitDao.findAll();
    }


    public Spit findById(String id){
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /** 删除
      * @param id id
      */
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据上级ID查询吐槽列表
     * @param parentid
     * @param page
     * @param size
     * @return org.springframework.data.domain.Page<com.tensquare.spit.pojo.Spit>
     */
    public Page<Spit> findByParentid(String parentid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid, pageRequest);
    }


    /** 点赞 */
    public void updateThumbup(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update=new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query, update,"spit");
    }

    public void add(Spit spit) {
        spit.set_id( idWorker.nextId()+"" );
        // 发布日期
        spit.setPublishtime(new Date());
        // 浏览量
        spit.setVisits(0);
        // 分享数
        spit.setShare(0);
        // 点赞数
        spit.setThumbup(0);
        // 回复数
        spit.setComment(0);
        // 状态
        spit.setState("1");
        if(spit.getParentid()!=null && !"".equals(spit.getParentid())){
        // 如果存在上级ID,评论
            Query query=new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update=new Update(); update.inc("comment",1);
            mongoTemplate.updateFirst(query,update,"spit");
        }
        spitDao.save(spit);
    }
}
