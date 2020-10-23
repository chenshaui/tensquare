package com.tensquare.qa.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pl
 * @author chenshuai
 **/
@Data
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "tb_pl")
public class Pl implements Serializable {
    /**
     * 问题ID
     */
    @Id
    private String problemid;

    /**
     * 标签ID
     */
    private String labelid;

    private static final long serialVersionUID = 1L;
}

