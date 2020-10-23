package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import com.tensquare.base.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenshuai
 */
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    public void add(Comment comment){
        comment.set_id(idWorker.nextId() + "");
        commentDao.save(comment);
    }

    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }
}
