package com.tensquare.use;

import com.tensquare.use.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author chenshuai
 */
public class ApplicationConfig  extends WebMvcConfigurationSupport {

    @Autowired
    private JwtFilter jwtFilter;

    @Override public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtFilter)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login");
    }
}
