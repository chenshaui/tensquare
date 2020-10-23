package com.tensquare.article.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Column
 * @author chenshuai
 **/
@Data
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "tb_column")
public class Column implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 专栏名称
     */
    private String name;

    /**
     * 专栏简介
     */
    private String summary;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 申请日期
     */
    private Date createtime;

    /**
     * 审核日期
     */
    private Date checktime;

    /**
     * 状态
     */
    private String state;

    private static final long serialVersionUID = 1L;
}

