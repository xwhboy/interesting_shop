package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZK on 6/22/16.
 */
@Entity
@Table(name = "proAttribute")
public class ProAttribute {
    private Integer proAttributeId;
    private String proAttributeName;

    private Product product;

    private Set<ProAttributeValue> values;

    @Id
    @Column(name = "pro_attribute_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getProAttributeId() {
        return proAttributeId;
    }

    public void setProAttributeId(Integer proAttributeId) {
        this.proAttributeId = proAttributeId;
    }

    @Basic
    @Column(name = "pro_attribute_name", nullable = false)
    public String getProAttributeName() {
        return proAttributeName;
    }

    public void setProAttributeName(String proAttributeName) {
        this.proAttributeName = proAttributeName;
    }

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "pro_ID", referencedColumnName = "pro_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @OneToMany(targetEntity = ProAttributeValue.class, mappedBy = "proAttribute")
    public Set<ProAttributeValue> getValues() {
        return values;
    }

    public void setValues(Set<ProAttributeValue> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProAttribute that = (ProAttribute) o;

        return proAttributeId.equals(that.proAttributeId);

    }

    @Override
    public int hashCode() {
        return proAttributeId.hashCode();
    }

    @Override
    public String toString() {
        return "ProAttribute{" +
                "proAttributeId=" + proAttributeId +
                ", proAttributeName='" + proAttributeName + '\'' +
                ", product=" + product +
                ", values=" + values +
                '}';
    }
}
