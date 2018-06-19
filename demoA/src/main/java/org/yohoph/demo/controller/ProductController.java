package org.yohoph.demo.controller;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yohoph.demo.entity.Product;
import org.yohoph.demo.service.ProductServiceImpl;
import org.yohoph.demo.tracking.RandomUtils;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:20
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@RestController
@RequestMapping("/demoa/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private Tracer tracer;

    @RequestMapping("executeProduct")
    public String executeProduct(String productId){
        tracer.currentSpan().tag("random-sleep-millis", String.valueOf(RandomUtils.random()));
        Product product = new Product();
        product.setProductId(productService.getProductId());
        productService.executeProduct(null);

        return "product ok";
    }

    @RequestMapping("getProductId")
    public String getProductId(){
        return "getProductId";
    }

}
