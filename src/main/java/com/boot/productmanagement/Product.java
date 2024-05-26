package com.boot.productmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String place;
    private  int warrenty;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", type=" + type + ", place=" + place + ", warrenty=" + warrenty
                + "]";
    }
    public Product(){};
   
   
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public Product(String name, String type, String place, int warrenty) {
    //     this.name = name;
    //     this.type = type;
    //     this.place = place;
    //     this.warrenty = warrenty;
    // }
    // public String getType() {
    //     return type;
    // }
    // public void setType(String type) {
    //     this.type = type;
    // }
    // public String getPlace() {
    //     return place;
    // }
    // public void setPlace(String place) {
    //     this.place = place;
    // }
    // public int getWarrenty() {
    //     return warrenty;
    // }
    // public void setWarrenty(int warrenty) {
    //     this.warrenty = warrenty;
    // }

    
}
