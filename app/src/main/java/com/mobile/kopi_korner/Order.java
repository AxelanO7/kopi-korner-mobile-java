package com.mobile.kopi_korner;

import java.io.Serializable;

public class Order implements Serializable {
    private String customerName, typeDrink;
    private Integer id, totalOrder, price;

    public Order() {
    }

    public Order(Integer id, String nameCustomer, String typeDrink, Integer totalOrder, Integer price) {
        this.id = id;
        this.customerName = nameCustomer;
        this.typeDrink = typeDrink;
        this.totalOrder = totalOrder;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTypeDrink() {
        return typeDrink;
    }

    public void setTypeDrink(String typeDrink) {
        this.typeDrink = typeDrink;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
