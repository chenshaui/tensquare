package com.tensquare.use.pojo;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "tb_user")
public class User implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * loginname
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生年月日
     */
    private Date birthday;

    /**
     * 头像
     */
    private String avatar;

    /**
     * mobile
     */
    private String mobile;

    /**
     * E-Mail
     */
    private String email;

    /**
     * 注册日期
     */
    private Date regdate;

    /**
     * 修改日期
     */
    private Date updatedate;

    /**
     * 最后登陆日期
     */
    private Date lastdate;

    /**
     * 在线时长（分钟）
     */
    private Long online;

    /**
     * 兴趣
     */
    private String interest;

    /**
     * 个性
     */
    private String personality;

    /**
     * 粉丝数
     */
    private Integer fanscount;

    /**
     * 关注数
     */
    private Integer followcount;

    private static final long serialVersionUID = 1L;
}

