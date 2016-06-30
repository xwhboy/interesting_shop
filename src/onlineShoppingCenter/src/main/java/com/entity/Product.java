package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZK on 6/21/16.
 */
@Entity
@Table(name = "product")
public class Product {
    private Integer proId;
    private String proName;
    private double proPrice;
    private String proDescription;
    private boolean isOnSale;
    private int proSellCount;
    private double proRealPrice;

    private Sort sort;

    private Set<User> collectedUsers;

    private Set<Picture> pictures;

    private Set<ProAttribute> proAttributes;

    private Set<Goods> goods;

    @Id
    @Column(name = "pro_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    @Basic
    @Column(name = "pro_decript")
    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    @Basic
    @Column(name = "pro_name", nullable = false)
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Basic
    @Column(name = "pro_onsale", nullable = false)
    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    @Basic
    @Column(name = "pro_price", nullable = false)
    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    @Basic
    @Column(name = "pro_realPrice", nullable = false)
    public double getProRealPrice() {
        return proRealPrice;
    }

    public void setProRealPrice(double proRealPrice) {
        this.proRealPrice = proRealPrice;
    }

    @Basic
    @Column(name = "pro_sellCount", nullable = false)
    public int getProSellCount() {
        return proSellCount;
    }

    public void setProSellCount(int proSellCount) {
        this.proSellCount = proSellCount;
    }

    @ManyToOne(targetEntity = Sort.class)
    @JoinColumn(name = "sort_ID", referencedColumnName = "sort_ID")
    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "collection",
            joinColumns = @JoinColumn(name = "pro_ID", referencedColumnName = "pro_ID"),
            inverseJoinColumns = @JoinColumn(name = "user_ID", referencedColumnName = "user_ID"))
    public Set<User> getCollectedUsers() {
        return collectedUsers;
    }

    public void setCollectedUsers(Set<User> collectedUsers) {
        this.collectedUsers = collectedUsers;
    }

    @OneToMany(targetEntity = Picture.class, mappedBy = "product")
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @OneToMany(targetEntity = ProAttribute.class, mappedBy = "product")
    public Set<ProAttribute> getProAttributes() {
        return proAttributes;
    }

    public void setProAttributes(Set<ProAttribute> proAttributes) {
        this.proAttributes = proAttributes;
    }

    @OneToMany(targetEntity = Goods.class, mappedBy = "product")
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

        Product product = (Product) o;

        return proId.equals(product.proId);

    }

    @Override
    public int hashCode() {
        return proId.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                ", pro_ID=" + proId +
                ", pro_name='" + proName + '\'' +
                ", pro_price=" + proPrice +
                ", pro_decript='" + proDescription + '\'' +
                ", pro_onsale=" + isOnSale +
                ", pro_sellCount=" + proSellCount +
                ", pro_realPrice=" + proRealPrice +
                ", sort=" + sort +
                ", pictures=" + pictures +
                '}';
    }
}
