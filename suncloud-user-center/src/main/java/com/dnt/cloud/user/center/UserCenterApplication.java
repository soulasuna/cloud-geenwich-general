package com.dnt.cloud.user.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * ProjectName: user-center
 * ClassName: UserCenterApplication
 * Date: 2018/12/11 16:10
 * Content: 用户中心启动类
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@SpringBootApplication
 @ComponentScan(basePackages = {
         "com.dnt.cloud.common.framework",
         "com.dnt.cloud.user.center"
 })
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
