package com.retail.headquarters.model;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Order implements Serializable{


    private int orderId;


    private List<WarehouseItem> orderInfo;


    private List<WarehouseItem> orderedItems;


    private String account;

    public Order(){

    }
    public Order(List<WarehouseItem> orderedItems, List<WarehouseItem> orderInfo, String account){
        this.orderId = 0;
        this.orderedItems = orderedItems;
        this.orderInfo = orderInfo;
        this.account = account;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<WarehouseItem> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List<WarehouseItem> orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<WarehouseItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<WarehouseItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderInfo='" + orderInfo + '\'' +
                ", orderedItems='" + orderedItems + '\'' +
                ", account='" + account + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() &&
                Objects.equals(getOrderInfo(), order.getOrderInfo()) &&
                Objects.equals(getOrderedItems(), order.getOrderedItems()) &&
                Objects.equals(getAccount(), order.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getOrderInfo(), getOrderedItems(), getAccount());
    }
}
