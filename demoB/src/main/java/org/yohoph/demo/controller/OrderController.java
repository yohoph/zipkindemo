package org.yohoph.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yohoph.demo.entity.Order;
import org.yohoph.demo.service.OrderServiceImpl;
import org.yohoph.demo.service.ProductServiceImpl;

import java.util.Date;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:22
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@RestController
@RequestMapping("/demob/order")
public class OrderController {

    @Autowired
    private ProductServiceImpl productService ;

    @Autowired
    private OrderServiceImpl orderService ;

    @RequestMapping("executeOrder")
    public String executeOrder(String orderName, String userId ,String productId){
        try {
            Order order = new Order();
            order.setOrderId(orderService.getOrderId());
            order.setProdoctId(productService.getProductId());
            order.setOrderName(userId);
            order.setCreateDate(new Date());
            orderService.executeOrder(order);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return "order ok";
    }

}
