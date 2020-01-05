package com.retail.headquarters.model;

import java.io.Serializable;
import java.util.Objects;


public class WarehouseItem implements Serializable {


    private int id;

    private int barcode;

    private String name;

    private String description;

    private int amount;

    public WarehouseItem(){

    }
    public WarehouseItem(int barcode, String name, String description, int amount) {
        this.id = 0;
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.amount = amount;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseItem that = (WarehouseItem) o;
        return getId() == that.getId() &&
                getBarcode() == that.getBarcode() &&
                getAmount() == that.getAmount() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBarcode(), getName(), getDescription(), getAmount());
    }

    @Override
    public String toString() {
        return "WarehouseItem{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}

