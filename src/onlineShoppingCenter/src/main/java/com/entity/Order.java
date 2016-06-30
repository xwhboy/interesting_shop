package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by ZK on 6/21/16.
 */
@Entity
@Table(name = "proOrder")
public class Order {
    private Integer orderId;
    private String orderFormNum;
    private String orderCheckName;
    private Date orderTime;
    private int orderTag;
    private String orderCheckAddress;
    private String orderDesc;
    private String orderCheckTel;
    private double orderTotalPrice;

    private User user;

    private Set<Goods> goods;

    @Id
    @Column(name = "order_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_check_address", nullable = false)
    public String getOrderCheckAddress() {
        return orderCheckAddress;
    }

    public void setOrderCheckAddress(String orderCheckAddress) {
        this.orderCheckAddress = orderCheckAddress;
    }

    @Basic
    @Column(name = "order_check_name", nullable = false)
    public String getOrderCheckName() {
        return orderCheckName;
    }

    public void setOrderCheckName(String orderCheckName) {
        this.orderCheckName = orderCheckName;
    }

    @Basic
    @Column(name = "order_desc")
    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Basic
    @Column(name = "order_form_num", nullable = false)
    public String getOrderFormNum() {
        return orderFormNum;
    }

    public void setOrderFormNum(String orderFormNum) {
        this.orderFormNum = orderFormNum;
    }

    @Basic
    @Column(name = "order_tag", nullable = false)
    public int getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(int orderTag) {
        this.orderTag = orderTag;
    }

    @Basic
    @Column(name = "order_time", nullable = false)
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "order_check_tel", nullable = false)
    public String getOrderCheckTel() {
        return orderCheckTel;
    }

    public void setOrderCheckTel(String orderCheckTel) {
        this.orderCheckTel = orderCheckTel;
    }

    @Basic
    @Column(name = "order_total_price", nullable = false)
    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_ID", referencedColumnName = "user_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(targetEntity = Goods.class)
    @JoinTable(name = "orderToGoods",
        joinColumns = @JoinColumn(name = "order_ID", referencedColumnName = "order_ID"),
        inverseJoinColumns = @JoinColumn(name = "goods_ID", referencedColumnName = "goods_ID"))
    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderId.equals(order.orderId);

    }

    @Override
    public int hashCode() {
        return orderId.hashCode();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCheckAddress='" + orderCheckAddress + '\'' +
                ", orderId=" + orderId +
                ", orderFormNum='" + orderFormNum + '\'' +
                ", orderCheckName='" + orderCheckName + '\'' +
                ", orderTime=" + orderTime +
                ", orderTag=" + orderTag +
                ", orderDesc='" + orderDesc + '\'' +
                ", orderCheckTel='" + orderCheckTel + '\'' +
                ", orderTotalPrice=" + orderTotalPrice +
                ", user=" + user +
                ", goods=" + goods +
                '}';
    }
}
