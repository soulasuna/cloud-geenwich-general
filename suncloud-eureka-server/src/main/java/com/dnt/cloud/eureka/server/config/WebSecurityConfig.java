package com.dnt.cloud.eureka.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ProjectName: suncloud-parent
 * ClassName: WebSecurityConfig
 * Date: 2018/12/11 12:45
 * Content: eureka服务配置类
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * eureka服务开启安全认证spring-boot-starter-security
     * 默认情况下,它将要求每次向应用程序发送请求时都会发送一个有效的CSRF令牌
     * Eureka客户端通常不会拥有有效的跨站点请求伪造（CSRF）令牌，
     * 您需要为 /eureka /** 端点禁用此要求。
     *
     * 详见官方文档:
     * https://cloud.spring.io/spring-cloud-static/Finchley.SR2/single/spring-cloud.html#spring-cloud-eureka-server
     *
     * @param http          http对象
     * @throws Exception    异常对象
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

}
