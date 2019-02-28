package com.dnt.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName: suncloud-parent
 * ClassName: FallbackController
 * Date: 2019/1/18 0:16
 * Content: 断容请求的方法
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@RestController
public class FallbackController {

    private final static Integer DEFAULT_RESULT_CODE = 100;
    private final static String DEFAULT_RESULT_MSG = "服务器暂停服务";


    @GetMapping(value = "/fallback")
    public Map<String,Object> fallback() {
        Map<String,Object> map = new HashMap<>(2);
        map.put("resultCode",DEFAULT_RESULT_CODE);
        map.put("resultMsg",DEFAULT_RESULT_MSG);
        return map;
    }

}
