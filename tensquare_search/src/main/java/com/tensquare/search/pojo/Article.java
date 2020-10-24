package com.tensquare.search.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;

/**
 * 文章实体类
 * @author chenshuai
 */
@Data
@ToString
@Document(indexName="tensquare",type="article")
public class Article {

    // ID
    @Id
    private String id;

    // 标题
    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;

    // 文章正文
    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;

    // 审核状态
    private String state;
}
