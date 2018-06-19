package org.yohoph.demo.service;

import com.jmsw.common.utils.GsonUtils;
import com.jmsw.common.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yohoph.demo.entity.Order;
import org.yohoph.demo.entity.Product;

import java.util.Date;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:50
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@Service
public class OrderServiceImpl {

    private ProductServiceImpl productService = new ProductServiceImpl();
    @Autowired
    RestTemplate restTemplate;

    public void executeOrder(Order order){
        Product product = new Product();
        product.setProductId(order.getProdoctId());
        product.setProductName("name" + order.getProdoctId());
        product.setCreateDate(new Date());
        restTemplate.getForObject("http://localhost:9002/demob/product/executeProduct",String.class);
        System.out.println("demob execute order :" + GsonUtils.parseJson(order)) ;
    }

    public String getOrderId(){
        return IdGen.uuid();
    }
}
