package com.tensquare.qa.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reply
 * @author chenshuai
 **/
@Data
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "tb_reply")
public class Reply implements Serializable {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 问题ID
     */
    private String problemid;

    /**
     * 回答内容
     */
    private String content;

    /**
     * 创建日期
     */
    private Date createtime;

    /**
     * 更新日期
     */
    private Date updatetime;

    /**
     * 回答人ID
     */
    private String userid;

    /**
     * 回答人昵称
     */
    private String nickname;

    private static final long serialVersionUID = 1L;
}

