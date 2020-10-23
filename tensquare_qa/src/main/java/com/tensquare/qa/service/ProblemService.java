package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author chenshuai
 */
@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;


    /**
     * 根据标签ID查询问题列表
     * @param lableId 标签ID
     * @param page 页码
     * @param size 页大小
     * @return
     */
    public Page<Problem> findNewListByLabelId(String lableId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return problemDao.findNewListByLabelId(lableId,pageRequest);
    }

    /**
     * 根据标签ID查询热门问题列表
     * @param lableId 标签ID
     * @param page 页码
     * @param size 页大小
     * @return
     */
    public Page<Problem> findHotListByLabelId(String lableId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return problemDao.findHotListByLabelId(lableId,pageRequest);
    }


    /**
     * 根据标签ID查询等待回答列表
     * @param lableId 标签ID
     * @param page 页码
     * @param size 页大小
     * @return
     */
    public Page<Problem> findWaitListByLabelId(String lableId,int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return problemDao.findWaitListByLabelId(lableId,pageRequest);
    }
}
