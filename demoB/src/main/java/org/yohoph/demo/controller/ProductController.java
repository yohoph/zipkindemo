package org.yohoph.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yohoph.demo.entity.Product;
import org.yohoph.demo.service.ProductServiceImpl;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:20
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@RestController
@RequestMapping("/demob/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;



    @RequestMapping("executeProduct")
    public String executeProduct(String productId){
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
