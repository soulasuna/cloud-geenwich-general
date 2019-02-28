package com.dnt.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ProjectName: suncloud-parent
 * ClassName: ConfigServerApplication
 * Date: 2018/12/11 10:50
 * Content: 配置中心
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
