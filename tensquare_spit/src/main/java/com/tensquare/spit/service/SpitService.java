package com.tensquare.spit.service;

import com.tensquare.base.utils.IdWorker;
import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Spit> findAll(){
        return spitDao.findAll();
    }


    public Spit findById(String id){
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    public void add(Spit spit) {
        //主键值 spitDao.save(spit);
        spit.set_id(idWorker.nextId()+"");

    }

    public void update(Spit spit) {
        spitDao.save(spit);
    }

    public void deleteById(String id) {
        spitDao.deleteById(id);
    }
}
