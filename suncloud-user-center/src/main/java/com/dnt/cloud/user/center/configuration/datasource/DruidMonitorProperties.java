package com.dnt.cloud.user.center.configuration.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * ProjectName: user-center
 * ClassName: DruidMonitorProperties
 * Date: 2019/2/28 14:51
 * Content: druid监控配置参数
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "custom.config.druid.monitor")
public class DruidMonitorProperties {

    private String servletIpWhiteAllow;
    private String servletIpBlackDeny;
    private String servletLoginUserName;
    private String servletLoginPassWord;
    private String servletResetEnable;

    private String filterPathExclusions;

}
