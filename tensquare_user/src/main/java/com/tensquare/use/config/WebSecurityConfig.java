package com.tensquare.use.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 全注解的开端
                .authorizeRequests()
                // antMatchers("/**")拦截的路径  permitAll()任意权限都可以访问
                .antMatchers("/**").permitAll()
                // 任何权限请求都要验证
                .anyRequest().authenticated()
                // 固定写法，csrf拦截失效，不放开所有跨域请求失效
                .and().csrf().disable();
    }
}
