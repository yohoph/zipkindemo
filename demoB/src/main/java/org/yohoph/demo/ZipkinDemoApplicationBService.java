package org.yohoph.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:25
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableTransactionManagement(proxyTargetClass = true)
public class ZipkinDemoApplicationBService extends SpringBootServletInitializer {

    public static final String CURRENT_VERSION = "v1";
    public static final String COMPATIBLE_VERSION = "v1,v2";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ZipkinDemoApplicationBService.class);
    }

    @Bean
    public Docket docket(@Value("${swagger.enable:true}")boolean enableSwagger) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("积木三维模型云")
                                .description("当前API版本" + CURRENT_VERSION + " 兼容API版本" + COMPATIBLE_VERSION)
                                .version(CURRENT_VERSION)
                                .build())
                .select().apis(RequestHandlerSelectors.basePackage(ZipkinDemoApplicationBService.class.getPackage().getName())).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZipkinDemoApplicationBService.class, args);
    }
}
