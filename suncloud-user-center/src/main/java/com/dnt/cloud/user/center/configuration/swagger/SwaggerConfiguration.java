package com.dnt.cloud.user.center.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ProjectName: user-center
 * ClassName: SwaggerConfiguration
 * Date: 2019/1/10 23:16
 * Content: 文档生成工具Swagger2配置类
 *
 * @author soulasuna
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

    /**
     * 因为 Swagger2的资源文件都是在jar包里面，如果不在此处配置加载静态资源，
     * 会导致请求http://localhost:/swagger-ui.html失败
     *  swagger资源配置
     *  <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
     *  <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
     *
     * @param registry  参数对象
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Swagger页面信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("SpringBoot基于Swagger2构建RESTful API")
                // 描述
                .description("用户模块")
                // 协议地址
                .termsOfServiceUrl("")
                // 版本号
                .version("1.0.0")
                // 作者信息
                .contact(new Contact("soulasuna", "#", "jacky7boy@163.com")).build();
    }

    /**
     * Swagger配置信息
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描的基本包
                .apis(RequestHandlerSelectors.basePackage("com.dnt.cloud.user.center.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(true);
    }
}
