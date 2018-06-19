package org.yohoph.demo.tracking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 17:44
 * @Description 使用HttpRestTemplate
 */
@Configuration
public class TracingConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
