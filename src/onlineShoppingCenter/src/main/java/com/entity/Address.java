package com.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by ZK on 6/21/16.
 */
@Entity
@Table(name = "address")
public class Address {
    private Integer addressId;
    private String addressDetail;
    private boolean isDefault = false;

    private User user;

    @Id
    @Column(name = "address_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address_detail")
    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Basic
    @Column(name = "address_is_default", nullable = false)
    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_ID", referencedColumnName = "user_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return addressId.equals(address.addressId);

    }

    @Override
    public int hashCode() {
        return addressId.hashCode();
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_detail='" + addressDetail + '\'' +
                ", address_ID=" + addressId +
                ", address_isdefault=" + isDefault +
                ", user=" + user +
                '}';
    }
}
