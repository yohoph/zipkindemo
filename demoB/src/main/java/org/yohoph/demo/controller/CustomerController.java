package org.yohoph.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yohoph.demo.service.CustomerServiceImpl;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/12 14:04
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@RestController
@RequestMapping("/demob/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("executeCustmer")
    public String executeCustmer(String custId){
        customerService.executeCustomer(custId);
        return "execute custmer ok";
    }

}
