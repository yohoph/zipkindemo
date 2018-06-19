package org.yohoph.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yohoph.demo.service.AddressServiceImpl;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/12 14:36
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@RestController
@RequestMapping("/demob/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @RequestMapping("executeAddress")
    public String executeAddress(String address){

        return "execute address ok";
    }

}
