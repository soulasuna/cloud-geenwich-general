package com.dnt.cloud.user.center.configuration.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.Properties;

/**
 * ProjectName: user-center
 * ClassName: DruidDataSourceProperties
 * Date: 2019/2/28 10:24
 * Content: 德鲁伊连接池参数配置
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {
    /**
     * jdbc四大参数
     */
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    /**
     * 初始链接数,最小链接数,最大连接数
     */
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    /**
     * 获取连接超时时间
     * 关闭的空闲连接,检测间隔时间(毫秒)
     * 单个连接最小存活时间(毫秒)
     */
    private Long maxWait;
    private Long timeBetweenEvictionRunsMillis;
    private Long minEvictableIdleTimeMillis;
    /**
     * 数据库监测配置
     */
    private String validationQuery;
    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    /**
     * filter过滤器
     */
    private String filters;
    private Properties connectionProperties;
}
