package org.yohoph.demo.controller;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yohoph.demo.service.AddressServiceImpl;
import org.yohoph.demo.tracking.RandomUtils;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/12 14:36
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@RestController
@RequestMapping("/demoa/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private Tracer tracer;

    @RequestMapping("executeAddress")
    public String executeAddress(String address){
        tracer.currentSpan().tag("random-sleep-millis", String.valueOf(RandomUtils.random()));
        return "execute address ok";
    }

}
