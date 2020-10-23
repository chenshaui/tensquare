package com.tensquare.article.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Channel
 * @author chenshuai
 **/
@Data
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "tb_channel")
public class Channel implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 频道名称
     */
    private String name;

    /**
     * 状态
     */
    private String state;

    private static final long serialVersionUID = 1L;
}

