package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZK on 6/21/16.
 */
@Entity
@Table(name = "sort")
public class Sort {
    private Integer sortId;
    private String sortName;

    private Set<Product> products;

    @Id
    @Column(name = "sort_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Basic
    @Column(name = "sort_name", nullable = false)
    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @OneToMany(targetEntity = Product.class, mappedBy = "sort")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sort sort = (Sort) o;

        return sortId.equals(sort.sortId);

    }

    @Override
    public int hashCode() {
        return sortId.hashCode();
    }

    @Override
    public String toString() {
        return "Sort{" +
                "products=" + products +
                ", sortId=" + sortId +
                ", sortName='" + sortName + '\'' +
                '}';
    }
}
