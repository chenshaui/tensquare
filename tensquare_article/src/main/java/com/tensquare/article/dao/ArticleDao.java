package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author chenshuai
 */
@Repository
public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    /**
     * 审核
     * @param id id
     */
    @Modifying
    @Query("update Article set state='1' where id=?1")
    void examine(String id);


    /**
     * 点赞
     * @param id id
     * @return int
     */
    @Modifying
    @Query("update Article a set thumbup = thumbup + 1 where id=?1")
    int updateThumbup(String id);
}
