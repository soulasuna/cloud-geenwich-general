package com.dnt.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProjectName: suncloud-gateway
 * ClassName: GatewayApplication
 * Date: 2018/12/11 10:55
 * Content: 统一网关服务
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}

