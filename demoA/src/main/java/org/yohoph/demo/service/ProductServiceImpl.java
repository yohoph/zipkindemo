package org.yohoph.demo.service;

import com.jmsw.common.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yohoph.demo.entity.Product;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:47
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@Service
public class ProductServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    public void executeProduct(Product product){
        restTemplate.getForObject("http://localhost:9001/demoa/customer/executeCustmer",String.class);
        System.out.println("execute product service");
    }

    public String getProductId(){
        return IdGen.uuid();
    }

}
