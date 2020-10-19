package com.tensquare.base.service;



import com.tensquare.base.pojo.Label;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 标签逻辑处理service
 * @author chenshuai
 */
public interface ILabelService {

    /**
     * 查询所有标签
     * @return java.util.List<pojo.Label>
     */
    List<Label> findAll();

    /**
     *
     * @param id id
     * @return pojo.Label
     */
    Label findById(String id);

    /**
     * 添加标签
     */
    void add(Label label);

    /**
     * 更新标签
     * @param label 标签对象
     */
    void update(Label label);

    /**
     * 通过id删除标签
     * @param id id
     */
    void deleteById(String id);

    /**
     * 条件查询
     * @param searchMap 条件map
     * @return java.util.List<com.tensquare.base.pojo.Label>
     * @throws Exception
     */
    List<Label> findSearch(Map searchMap);


    /**
     * 分页查询
     * @param searchMap 条件参数
     * @param page 页数
     * @param size 大小
     * @return org.springframework.data.domain.Page<com.tensquare.base.pojo.Label>
     */
    Page<Label> findSearch(Map searchMap, int page, int size);
}
