package com.dnt.cloud.gateway.limit.resolver;

import com.dnt.cloud.gateway.utils.ExchangeHandlerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ProjectName: suncloud-parent
 * ClassName: HeadKeyResolver
 * Date: 2019/1/17 22:11
 * Content: 自定义限流规则
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@Component(value = "headKeyResolver")
public class HeadKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String token = ExchangeHandlerUtils.getHeaderValueByKey(exchange, "token");
        log.info("====测试添加====token:{}",token);
        return Mono.just(token);
    }
}
