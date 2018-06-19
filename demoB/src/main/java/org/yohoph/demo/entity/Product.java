package org.yohoph.demo.entity;

import java.util.Date;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:24
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
public class Product {

    private String productId;

    private String productName;

    private Integer price;

    private Date createDate;

    private Date updateDate;

    public Product() {
    }

    public Product(String productId, String productName, Integer price, Date createDate, Date updateDate) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
