package com.tensquare.spit.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author chenshuai
 */
@Data
@ToString
public class Spit {
    @Id
    private String _id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;
}
