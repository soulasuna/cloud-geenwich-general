package com.dnt.cloud.gateway.filter.global;

import com.dnt.cloud.gateway.utils.ExchangeHandlerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * ProjectName: suncloud-parent
 * ClassName: TokenFilter
 * Date: 2019/1/17 14:13
 * Content: 全局的过滤器样例
 *          校验请求头中是否包含token
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter, Ordered {

    /*--------------------static_filed--------------------*/
    /**
     * 默认在header中取值的key
     */
    private final static String  HEADER_KEY_TOKEN = "token";

    /*--------------------business_method--------------------*/
    /**
     * filter主要逻辑
     * 如果请求头里面tokens包含1*,不包含拦截
     * @param exchange  请求对象
     * @param chain     过滤对象
     * @return          返回数据
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /**
         * 获得请求头中token
         */
        String token = ExchangeHandlerUtils.getHeaderValueByKey(exchange, HEADER_KEY_TOKEN);
        if(token == null){
            /**
             * 设置请求状态未授权
             */
            ServerHttpResponse response = ExchangeHandlerUtils.getResponse(exchange);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器有限制设置
     * 数值越小，优先级越高
     *
     * 自定义GlobalFilter如果想要在GatewayFilter前面执行
     * 这里设置的值必须大于大于等于1
     * 如果想要在GatewayFilter后执行那么
     *
     * 全局的过滤器如果想在GatewayFilter后面执行就要看
     * 有多少个GatewayFilter(排序从1开始)
     *
     * 值相同的情况GlobalFilter优先于GatewayFilter执行
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 5;
    }
}
