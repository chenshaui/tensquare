package com.tensquare.base.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签实体
 * @author chenshuai
 */
@Entity
@Table(name="tb_label")
@Data
@ToString
public class Label {

    /** id **/
    @Id
    private String id;
    /** 标签名称 **/
    private String labelName;
    /** 状态 **/
    private String state;
    /** 使用数量 **/
    private Long count;
    /** 关注数 **/
    private Long fans;
    /** 是否推荐 **/
    private String recommend;
}
