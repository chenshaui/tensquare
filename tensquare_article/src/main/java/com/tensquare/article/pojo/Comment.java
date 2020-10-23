package com.tensquare.article.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenshuai
 */
@Data
@ToString
public class Comment implements Serializable {

    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;
}
