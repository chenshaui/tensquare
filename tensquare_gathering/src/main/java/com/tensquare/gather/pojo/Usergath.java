package com.tensquare.gather.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usergath
 * @author chenshuai
 **/
@Data
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "tb_usergath")
public class Usergath implements Serializable {
    /**
     * 用户ID
     */
    @Id
    private String userid;

    /**
     * 活动ID
     */
    private String gathid;

    /**
     * 点击时间
     */
    private Date exetime;

    private static final long serialVersionUID = 1L;
}

