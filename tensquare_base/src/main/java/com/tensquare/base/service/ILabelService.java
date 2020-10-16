package com.tensquare.base.service;



import com.tensquare.base.pojo.Label;

import java.util.List;

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
}
