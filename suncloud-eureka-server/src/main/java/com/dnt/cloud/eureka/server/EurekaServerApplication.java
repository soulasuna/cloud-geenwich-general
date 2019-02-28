package com.dnt.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ProjectName: eureka-server
 * ClassName: EurekaServerApplication
 * Date: 2018/12/11 10:55
 * Content: 服务注册中心
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
