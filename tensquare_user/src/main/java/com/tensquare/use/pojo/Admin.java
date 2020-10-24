package com.tensquare.use.pojo;

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
@Table(name = "tb_admin")
public class Admin implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 登陆名称
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private String state;

    private static final long serialVersionUID = 1L;
}

