package com.dnt.cloud.gateway.utils;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

/**
 * ProjectName: suncloud-parent
 * ClassName: ExchangeHandlerUtils
 * Date: 2019/1/17 15:38
 * Content: webflux编程处理ServerWebExchange对象的工具类
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
public class ExchangeHandlerUtils {







    /*--------------------get_object--------------------*/

    /**
     * ServerWebExchange对象中获得ServerHttpRequest
     * @param exchange  ServerWebExchange对象
     * @return          ServerHttpRequest对象
     */
    public static ServerHttpRequest getRequest(ServerWebExchange exchange){
        return exchange.getRequest();
    }

    /**
     * ServerWebExchange对象中获得ServerHttpResponse
     * @param exchange  ServerWebExchange对象
     * @return          ServerHttpResponse对象
     */
    public static ServerHttpResponse getResponse(ServerWebExchange exchange){
        return exchange.getResponse();
    }


    /**
     * 根据key获得请求头里面的信息
     * 对应的数组信息
     * @param exchange  ServerWebExchange对象
     * @param key       header中取值对应的key
     * @return          key对应的集合类型values
     */
    public static List<String> getHeaderValuesByKey(ServerWebExchange exchange, String key){
        return getRequest(exchange).getHeaders().get(key);
    }


    /**
     * 根据key获得请求头里面的信息
     * 对应的数据信息
     * @param exchange  ServerWebExchange对象
     * @param key       header中取值对应的key
     * @return          key对应的字符串类型value
     */
    public static String getHeaderValueByKey(ServerWebExchange exchange, String key){
        return getRequest(exchange).getHeaders().getFirst(key);
    }


}
