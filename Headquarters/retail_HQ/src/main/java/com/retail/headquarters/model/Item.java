package com.retail.headquarters.model;



import java.io.Serializable;
import java.util.Objects;


public class Item implements Serializable {


    private int id;

    private int barcode;

    private String name;

    private String description;

    public Item(){

    }
    public Item(int barcode, String name, String description) {
        this.id = 0;
        this.barcode = barcode;
        this.name = name;
        this.description = description;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                getBarcode() == item.getBarcode() &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getDescription(), item.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBarcode(), getName(), getDescription());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
