package org.yohoph.demo.controller;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yohoph.demo.service.CustomerServiceImpl;
import org.yohoph.demo.tracking.RandomUtils;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/12 14:04
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@RestController
@RequestMapping("/demoa/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private Tracer tracer;

    @RequestMapping("executeCustmer")
    public String executeCustmer(String custId){
        tracer.currentSpan().tag("random-sleep-millis", String.valueOf(RandomUtils.random()));
        customerService.executeCustomer(custId);
        return "execute custmer ok";
    }

}
