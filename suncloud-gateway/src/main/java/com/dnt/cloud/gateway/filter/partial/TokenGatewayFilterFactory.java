package com.dnt.cloud.gateway.filter.partial;


import com.dnt.suncloud.gateway.filter.config.EnabledConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * ProjectName: suncloud-parent
 * ClassName: TokenGatewayFilterFactory
 * Date: 2019/1/16 16:17
 * Content: 局部
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<EnabledConfig> {

    /*--------------------static_filed--------------------*/

    private final static String CONFIG_FILED_NAME = "enabled";

    /**
     * 构造配置类传递给父类
     * 源码
     * public AbstractGatewayFilterFactory(Class<C> configClass) {
     *         super(configClass);
     * }
     *
     * 如果不传会报找不到类的异常
     *
     */
    public TokenGatewayFilterFactory() {
        super(EnabledConfig.class);
    }

    /**
     * 配合config中字段的名称
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(CONFIG_FILED_NAME);
    }

    @Override
    public GatewayFilter apply(EnabledConfig tokenConfig) {
        return (exchange, chain) ->{
            if (!tokenConfig.isEnabled()) {
                return chain.filter(exchange);
            }
            /**
             * 添加请求时间
             */
            long startTime = System.currentTimeMillis();
            log.info("====测试添加====请求开始时间====startTime:{}",startTime);
            exchange.getAttributes().put("startTime",startTime);
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() ->{
                        Long start = exchange.getAttribute("startTime");
                        log.info("====测试添加====计算请求时间====consumeTime:{}",
                                System.currentTimeMillis() - start);
                    })
            );
        };
    }

}
