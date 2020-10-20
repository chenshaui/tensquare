package util;

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
                .authorizeRequests()  // 全注解的开端
                .antMatchers("/**").permitAll() // antMatchers("/**")拦截的路径  permitAll()任意权限都可以访问
                .anyRequest().authenticated() // 任何权限请求都要验证
                .and().csrf().disable(); // 固定写法，csrf拦截失效，不放开所有跨域请求失效
    }
}
