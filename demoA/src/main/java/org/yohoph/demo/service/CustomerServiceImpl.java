package org.yohoph.demo.service;

import brave.SpanCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/12 14:03
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@Service
public class CustomerServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    public void executeCustomer(String custId){
        restTemplate.postForObject("http://localhost:9001/demoa/address/executeAddress",null ,String.class);
        System.out.println("execute custormer ok");
    }

}
