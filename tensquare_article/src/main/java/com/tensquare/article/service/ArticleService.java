package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;

/**
 * @author chenshuai
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 文章审核
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    public void examine (String id) {
        articleDao.examine(id);
    }

    /**
     * 点赞
     * @param id 文章ID
     * @return int
     */
    @Transactional(rollbackOn = Exception.class)
    public int updateThumbup (String id) {
        return articleDao.updateThumbup(id);
    }

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Article findById(String id) {
        //从缓存中提取
        Article article = (Article)redisTemplate.opsForValue().get("article_"+id);
        // 如果缓存没有则到数据库查询并放入缓存
        if(article == null) {
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_" + id, article,1, TimeUnit.DAYS);
        }
        return article;
    }

    // @Cacheable-------使用这个注解的方法在执行后会缓存其返回结果。
    // @CacheEvict--------使用这个注解的方法在其执行前或执行后移除Spring Cache中的某些元素。


    /**
     * 修改
     * @param article
     */
    public void update (Article article) {
        redisTemplate.delete("article_" + article.getId());//删除缓存
        articleDao.save(article);
    }
    /**
     * 删除
     * @param id
     */
    public void deleteById (String id) {
        redisTemplate.delete("article_" + id);//删除缓存
        articleDao.deleteById(id);
    }
}
