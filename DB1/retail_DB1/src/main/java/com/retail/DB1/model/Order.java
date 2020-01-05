package com.retail.DB1.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "order_id")
    private int orderId;

    @Column( name = "order_info")
    private String orderInfo;

    @Column( name =  "ordered_items")
    private String orderedItems;

    @Column( name = "account_login")
    private String account;

    public Order(){

    }
    public Order(String orderedItems, String orderInfo, String account){
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

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(String orderedItems) {
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
