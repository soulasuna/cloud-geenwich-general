package com.dnt.cloud.user.center.controller;

import com.dnt.cloud.common.enumeration.ExceptionStatusEnum;
import com.dnt.cloud.common.exception.MyException;
import com.dnt.cloud.user.center.configuration.datasource.DruidDataSourceProperties;
import com.dnt.cloud.user.center.configuration.datasource.DruidMonitorProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName: user-center
 * ClassName: DomeController
 * Date: 2018/12/11 16:20
 * Content: 测试config配置接口
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class DomeController {

    @Autowired
    private DruidDataSourceProperties druidDataSourceProperties;

    @Autowired
    private DruidMonitorProperties druidMonitorProperties;

    @GetMapping(value = "/config")
    public String getConfig(){
        log.info("druidDataSourceProperties:{}",druidDataSourceProperties.toString());
        log.info("druidMonitorProperties:{}",druidMonitorProperties.toString());
        return "SUCCESS";
    }

    @GetMapping(value = "/exception")
    public String exceptionTest(){
        try{
            int a = 1/0;
        }catch (Exception e){
            throw new MyException(ExceptionStatusEnum.ERROR_PARAM_EXCEPTION,e);
        }
        return "SUCCESS";
    }

}
