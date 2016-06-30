package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZK on 6/27/16.
 */

@Entity
@Table(name = "pro_attribute_value")
public class ProAttributeValue {
    private Integer proAttributeValueId;
    private String proAttributeValueName;
    private int proCount;

    private ProAttribute proAttribute;

    private Set<Goods> goods;

    @Id
    @Column(name = "pro_attribute_value_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getProAttributeValueId() {
        return proAttributeValueId;
    }

    public void setProAttributeValueId(Integer proAttributeValueId) {
        this.proAttributeValueId = proAttributeValueId;
    }

    @Basic
    @Column(name = "pro_attribute__value_name", nullable = false)
    public String getProAttributeValueName() {
        return proAttributeValueName;
    }

    public void setProAttributeValueName(String proAttributeValueName) {
        this.proAttributeValueName = proAttributeValueName;
    }

    @Basic
    @Column(name = "pro_count", nullable = false)
    public int getProCount() {
        return proCount;
    }

    public void setProCount(int proCount) {
        this.proCount = proCount;
    }

    @ManyToOne(targetEntity = ProAttribute.class)
    @JoinColumn(name = "pro_attribute_ID", referencedColumnName = "pro_attribute_ID")
    public ProAttribute getProAttribute() {
        return proAttribute;
    }

    public void setProAttribute(ProAttribute proAttribute) {
        this.proAttribute = proAttribute;
    }

    @ManyToMany(targetEntity = Goods.class)
    @JoinTable(name = "goodsToProAttributeValue",
        joinColumns = @JoinColumn(name = "pro_attribute_value_ID", referencedColumnName = "pro_attribute_value_ID"),
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

        ProAttributeValue that = (ProAttributeValue) o;

        return proAttributeValueId.equals(that.proAttributeValueId);

    }

    @Override
    public int hashCode() {
        return proAttributeValueId.hashCode();
    }

    @Override
    public String toString() {
        return "ProAttributeValue{" +
                "goods=" + goods +
                ", proAttributeValueId=" + proAttributeValueId +
                ", proAttributeValueName='" + proAttributeValueName + '\'' +
                ", proCount=" + proCount +
                ", proAttribute=" + proAttribute +
                '}';
    }
}
