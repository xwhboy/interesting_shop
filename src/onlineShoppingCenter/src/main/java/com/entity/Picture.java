package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ZK on 6/24/16.
 */
@Entity
@Table(name = "picture")
public class Picture {
    private Integer picId;
    private String picUrl;

    private Product product;

    @Id
    @Column(name = "pic_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    @Basic
    @Column(name = "pic_url")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "pro_ID", referencedColumnName = "pro_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
