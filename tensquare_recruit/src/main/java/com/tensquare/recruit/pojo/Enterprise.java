package com.tensquare.recruit.pojo;


import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "tb_enterprise")
/**
 * Enterprise
 * @author chenshuai
 **/
public class Enterprise implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 企业名称
     */

    private String name;

    /**
     * 企业简介
     */

    private String summary;

    /**
     * 企业地址
     */

    private String address;

    /**
     * 标签列表
     */

    private String labels;

    /**
     * 坐标
     */

    private String coordinate;

    /**
     * 是否热门
     */

    private String ishot;

    /**
     * LOGO
     */

    private String logo;

    /**
     * 职位数
     */

    private Integer jobcount;

    /**
     * URL
     */

    private String url;

    private static final long serialVersionUID = 1L;
}

