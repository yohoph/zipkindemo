package org.yohoph.demo.entity;

import java.util.Date;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 16:25
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
public class Order {

    private String orderId;

    private String orderName;

    private String prodoctId;

    private Integer orderPrice;

    private Date createDate;

    private Date updateDate;

    public Order() {
    }

    public Order(String orderId, String orderName, String prodoctId, Integer orderPrice, Date createDate, Date updateDate) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.prodoctId = prodoctId;
        this.orderPrice = orderPrice;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getProdoctId() {
        return prodoctId;
    }

    public void setProdoctId(String prodoctId) {
        this.prodoctId = prodoctId;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
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
