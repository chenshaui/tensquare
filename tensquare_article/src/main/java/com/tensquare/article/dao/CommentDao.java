package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenshuai
 */
@Repository
public interface CommentDao extends MongoRepository<Comment, String> {
    List<Comment> findByArticleid(String articleid);
}
