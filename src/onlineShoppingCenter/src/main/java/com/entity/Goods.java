package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZK on 6/27/16.
 */

@Entity
@Table(name = "goods")
public class Goods {
    private Integer goodsId;

    private int goodsCount;

    private Product product;

    private Set<User> cartUsers;

    private Set<ProAttributeValue> proAttributeValues;

    private Set<Order> orders;

    @Id
    @Column(name = "goods_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_count", nullable = false)
    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "pro_ID", referencedColumnName = "pro_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToMany(targetEntity = ProAttributeValue.class)
    @JoinTable(name = "goodsToProAttributeValue",
            joinColumns = @JoinColumn(name = "goods_ID", referencedColumnName = "goods_ID"),
            inverseJoinColumns = @JoinColumn(name = "pro_attribute_value_ID", referencedColumnName = "pro_attribute_value_ID"))
    public Set<ProAttributeValue> getProAttributeValues() {
        return proAttributeValues;
    }

    public void setProAttributeValues(Set<ProAttributeValue> proAttributeValues) {
        this.proAttributeValues = proAttributeValues;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "cart",
            joinColumns = @JoinColumn(name = "goods_ID", referencedColumnName = "goods_ID"),
            inverseJoinColumns = @JoinColumn(name = "user_ID", referencedColumnName = "user_ID"))
    public Set<User> getCartUsers() {
        return cartUsers;
    }

    public void setCartUsers(Set<User> cartUsers) {
        this.cartUsers = cartUsers;
    }

    @ManyToMany(targetEntity = Order.class)
    @JoinTable(name = "orderToGoods",
            joinColumns = @JoinColumn(name = "goods_ID", referencedColumnName = "goods_ID"),
            inverseJoinColumns = @JoinColumn(name = "order_ID", referencedColumnName = "order_ID"))
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        return goodsId.equals(goods.goodsId);

    }

    @Override
    public int hashCode() {
        return goodsId.hashCode();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsCount=" + goodsCount +
                ", goodsId=" + goodsId +
                ", product=" + product +
                ", proAttributeValues=" + proAttributeValues +
                '}';
    }
}
