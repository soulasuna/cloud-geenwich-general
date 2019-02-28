package com.dnt.cloud.user.center.configuration.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ProjectName: user-center
 * ClassName: DruidDataSourceConfiguration
 * Date: 2019/2/28 10:21
 * Content: druid连接池参数配置
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class, DruidMonitorProperties.class})
public class DruidDataSourceConfiguration {

    /*--------------------static--------------------*/
    /**
     * druid监控Servlet配置参数key值
     */
    private final static String DEFAULT_PATH = "/druid/*";

    private final static String SERVLET_IP_WHITE_ALLOW = "allow";
    private final static String SERVLET_IP_BLACK_DENY = "deny";
    private final static String SERVLET_LOGIN_USER_NAME = "loginUsername";
    private final static String SERVLET_LOGIN_PASS_WORD = "loginPassword";
    private final static String SERVLET_RESET_ENABLE = "resetEnable";
    /**
     * druid拦截器filter配置参数key值
     */
    private final static String FILTER_URL_PATTERNS = "/*";
    private final static String FILTER_PATH_EXCLUSIONS = "exclusions";

    private final static String FILTER_PATH_EXCLUSIONS_VALUES = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";


    /*--------------------business--------------------*/

    /**
     * 连接池参数对象
     */
    @Autowired
    private DruidDataSourceProperties druidDataSourceProperties;

    /**
     * druid监控配置
     */
    @Autowired
    private DruidMonitorProperties druidMonitorProperties;

    /**
     * 获得数据源datasource
     * @return  druid数据源对象
     */
    @Bean(value = "druidDataSource")
    @Primary
    @RefreshScope
    public DataSource getDataSource(){
        DruidDataSource druidDatasource = new DruidDataSource();
        /**
         * jdbc四大基本参数
         */
        druidDatasource.setDriverClassName(druidDataSourceProperties.getDriverClassName());
        druidDatasource.setUrl(druidDataSourceProperties.getUrl());
        druidDatasource.setUsername(druidDataSourceProperties.getUsername());
        druidDatasource.setPassword(druidDataSourceProperties.getPassword());
        /**
         * 链接池参数配置
         */
        druidDatasource.setInitialSize(druidDataSourceProperties.getInitialSize());
        druidDatasource.setMinIdle(druidDataSourceProperties.getMinIdle());
        druidDatasource.setMaxActive(druidDataSourceProperties.getMaxActive());
        druidDatasource.setMaxWait(druidDataSourceProperties.getMaxWait());
        druidDatasource.setTimeBetweenEvictionRunsMillis(druidDataSourceProperties.getTimeBetweenEvictionRunsMillis());
        druidDatasource.setMinEvictableIdleTimeMillis(druidDataSourceProperties.getMinEvictableIdleTimeMillis());
        druidDatasource.setValidationQuery(druidDataSourceProperties.getValidationQuery());
        druidDatasource.setTestWhileIdle(druidDataSourceProperties.getTestWhileIdle());
        druidDatasource.setTestOnBorrow(druidDataSourceProperties.getTestOnBorrow());
        druidDatasource.setTestOnReturn(druidDataSourceProperties.getTestOnReturn());
        /**
         * 过滤器
         */
        try {
            druidDatasource.setFilters(druidDataSourceProperties.getFilters());
            druidDatasource.setConnectProperties(druidDataSourceProperties.getConnectionProperties());
            druidDatasource.init();
        } catch (SQLException e) {
            log.error("error : druid datasource init filters filed error message:{}"+ e);
        }
        return druidDatasource;
    }

    /**
     * 注册Servlet信息， 配置监控视图
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet() {
        ServletRegistrationBean<Servlet> servletRegistrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(), DEFAULT_PATH);
        // ip白名单:
        servletRegistrationBean.addInitParameter(SERVLET_IP_WHITE_ALLOW,druidMonitorProperties.getServletIpWhiteAllow());
        // IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter(SERVLET_IP_BLACK_DENY,druidMonitorProperties.getServletIpBlackDeny());
        // 登录查看信息的账号密码, 用于登录Druid监控后台
        servletRegistrationBean.addInitParameter(SERVLET_LOGIN_USER_NAME, druidMonitorProperties.getServletLoginUserName());
        servletRegistrationBean.addInitParameter(SERVLET_LOGIN_PASS_WORD, druidMonitorProperties.getServletLoginPassWord());
        // 是否能够重置数据.
        servletRegistrationBean.addInitParameter(SERVLET_RESET_ENABLE, druidMonitorProperties.getServletResetEnable());
        return servletRegistrationBean;
    }

    /**
     * 注册Filter信息, 监控拦截器
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns(FILTER_URL_PATTERNS);
        /**
         * 拦截取出静态文件和监控页面路径
         */
        filterRegistrationBean.addInitParameter(FILTER_PATH_EXCLUSIONS, druidMonitorProperties.getFilterPathExclusions());
        return filterRegistrationBean;
    }

}
