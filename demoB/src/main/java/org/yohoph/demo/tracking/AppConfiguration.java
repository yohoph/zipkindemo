package org.yohoph.demo.tracking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 19:12
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@Configuration
public class AppConfiguration {

    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
