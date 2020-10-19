package com.tensquare.base.service.impl;


import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.ILabelService;
import com.tensquare.base.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 标签处理实现
 * @author chenshuai
 */
@Service
public class LabelServiceImpl implements ILabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    @Override
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public void add(Label label) {
        //设置ID
        label.setId( idWorker.nextId()+"" );
        labelDao.save(label);
    }

    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

    @Override
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    @Override
    public List<Label> findSearch(Map searchMap) {
        Specification<Label> specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     * 构建查询条件
     * @param searchMap 条件map
     * @return org.springframework.data.jpa.domain.Specification<com.tensquare.base.pojo.Label>
     */
    private Specification<Label> createSpecification(Map searchMap){
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if(searchMap.get("labelname") != null && !"".equals(searchMap.get("labelname"))){
                    predicateList.add(criteriaBuilder.like( root.get("labelname").as(String.class), "%"+ (String)searchMap.get("labelname")+"%"));
                }
                if(searchMap.get("state") != null && !"".equals(searchMap.get("state"))){
                    predicateList.add(criteriaBuilder.equal( root.get("state").as(String.class), (String)searchMap.get("state")));
                }
                if(searchMap.get("recommend") != null && !"".equals(searchMap.get("recommend"))){
                    predicateList.add(criteriaBuilder.equal( root.get("recommend").as(String.class), (String)searchMap.get("recommend")));
                }
                return criteriaBuilder.and( predicateList.toArray( new Predicate[predicateList.size()]) );
            }
        };
    }

    @Override
    public Page<Label> findSearch(Map searchMap, int page, int size){
        Specification specification= createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll( specification ,pageRequest);
    }
}
