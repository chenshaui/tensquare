package com.tensquare.search;

import com.tensquare.base.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 * @author chenshuai
 */
@SpringBootApplication
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}
