package com.tensquare.gather;

import com.tensquare.base.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * 启动类
 * @author chenshuai
 */
@SpringBootApplication
@EnableCaching
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
