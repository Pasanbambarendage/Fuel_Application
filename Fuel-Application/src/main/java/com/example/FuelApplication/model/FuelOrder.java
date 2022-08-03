package com.example.FuelApplication.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "FuelOrder")
public class FuelOrder {

    @Id
    private int orderID;
    private String shedName;
    private int shedId;
    private String shedLocation;
    private int capacity;
    private String fuelType;
    private String status ="Pending";

    public FuelOrder(){

    }

    public FuelOrder(int orderID, String shedName, int shedId, String shedLocation, int capacity, String fuelType, String status) {
        this.orderID = orderID;
        this.shedName = shedName;
        this.shedId = shedId;
        this.shedLocation = shedLocation;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getShedName() {
        return shedName;
    }

    public void setShedName(String shedName) {
        this.shedName = shedName;
    }

    public int getShedId() {
        return shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }

    public String getShedLocation() {
        return shedLocation;
    }

    public void setShedLocation(String shedLocation) {
        this.shedLocation = shedLocation;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
