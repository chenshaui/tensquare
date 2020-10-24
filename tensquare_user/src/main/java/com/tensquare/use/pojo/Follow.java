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
@Table(name = "tb_follow")
public class Follow implements Serializable {
    /**
     * 用户ID
     */
    @Id
    private String userid;

    /**
     * 被关注用户ID
     */
    @Id
    private String targetuser;

    private static final long serialVersionUID = 1L;
}

