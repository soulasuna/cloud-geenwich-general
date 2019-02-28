package com.dnt.cloud.common.framework.controller;

import com.dnt.cloud.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName: common
 * ClassName: MyErrorController
 * Date: 2019/1/2 10:42
 * Content: 统一异常处理类
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@Controller
@RequestMapping(value = "/error")
public final class MyErrorController extends BasicErrorController {
    /**
     * 常量异常归属类
     */
    public static final String ERROR_ATTRIBUTE = DefaultErrorAttributes.class.getName() + ".ERROR";


    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        super(errorAttributes, serverProperties.getError());
    }

    /**
     * 返回到错误页面的异常
     * @param request   request
     * @param response  response
     * @return          ModelAndView
     */
    @RequestMapping(produces = "text/html")
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        return super.errorHtml(request, response);
    }


    @RequestMapping
    @ResponseBody
    @Override
    @SuppressWarnings("unchecked")
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request){
        /**
         * 错误的原始消息体
         */
        Map<String, Object> body = super.getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        log.debug("原始消息体：{}", body);

        String message = body.get("message") != null ? (String) body.get("message") : null;
        String error = body.get("error") != null ? (String) body.get("error") : null;
        Integer statusCode = body.get("status") != null ? (Integer) body.get("status") : null;
        /**
         * 获得当前的异常
         */
        Throwable exception = this.getException(request);
        /**
         * 判断异常是不是自定义异常
         */
        if(exception instanceof MyException){
            MyException myException = (MyException) exception;
            statusCode = myException.getCode();
        }

        Map<String, Object> respMap = new HashMap<>(2);
        respMap.put("code",statusCode);
        respMap.put("message",message);
        respMap.put("error", error);
        respMap.put("data", body);
        /**
         * http状态码
         */
        HttpStatus status = super.getStatus(request);
        return new ResponseEntity<>(respMap, status);
    }

    @SuppressWarnings("unchecked")
    private <T> T getAttribute(RequestAttributes requestAttributes, String name) {
        return (T) requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
    }

    /**
     * 返回当前异常
     * @param request   请求
     * @return          异常
     */
    private Throwable getException(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Throwable exception = getAttribute(
                requestAttributes,
                ERROR_ATTRIBUTE
        );

        if (exception == null) {
            exception = getAttribute(requestAttributes, "javax.servlet.error.exception");
        }
        return exception;
    }
}
