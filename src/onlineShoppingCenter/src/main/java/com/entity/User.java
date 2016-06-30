package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZK on 6/21/16.
 */
@Entity
@Table(name = "user")
public class User {
    private Integer userId;
    private String userAccount;
    private String userPassword;
    private String userTel;

    private Set<Order> orders;
    private Set<Address> address;
    private Set<Product> collectedProducts;
    private Set<Goods> cartGoods;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    public User(String userAccount, String userPassword, String userTel) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userTel = userTel;
    }

    @Id
    @Column(name = "user_ID", nullable = false)
    @GenericGenerator(name = "hilo_generator", strategy = "hilo")
    @GeneratedValue(generator = "hilo_generator")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_account", nullable = false, unique = true)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_pw", nullable = false)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_tel", nullable = false, unique = true)
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @OneToMany(targetEntity = Address.class, mappedBy = "user")
    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    @ManyToMany(targetEntity = Product.class)
    @JoinTable(name = "collection",
        joinColumns = @JoinColumn(name = "user_ID", referencedColumnName = "user_ID"),
        inverseJoinColumns = @JoinColumn(name = "pro_ID", referencedColumnName = "pro_ID"))
    public Set<Product> getCollectedProducts() {
        return collectedProducts;
    }

    public void setCollectedProducts(Set<Product> collectedProducts) {
        this.collectedProducts = collectedProducts;
    }

    @ManyToMany(targetEntity = Goods.class)
    @JoinTable(name = "cart",
            joinColumns = @JoinColumn(name = "user_ID", referencedColumnName = "user_ID"),
            inverseJoinColumns = @JoinColumn(name = "goods_ID", referencedColumnName = "goods_ID"))
    public Set<Goods> getCartGoods() {
        return cartGoods;
    }

    public void setCartGoods(Set<Goods> cartGoods) {
        this.cartGoods = cartGoods;
    }

    @OneToMany(targetEntity = Order.class, mappedBy = "user")
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

        User user = (User) o;

        return userId.equals(user.userId);

    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userTel='" + userTel + '\'' +
                ", orders=" + orders +
                ", collections=" + collectedProducts +
                '}';
    }
}
