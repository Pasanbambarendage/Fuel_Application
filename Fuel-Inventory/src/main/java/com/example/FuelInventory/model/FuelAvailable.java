package com.example.FuelInventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Fuel_Available")
public class FuelAvailable {

    @Id
    private int fuelID;
    private String fuelType;
    private int fuelQuantity;

    public FuelAvailable(){

    }

    public FuelAvailable(int fuelID, String fuelType, int fuelQuantity) {
        this.fuelID = fuelID;
        this.fuelType = fuelType;
        this.fuelQuantity = fuelQuantity;
    }

    public int getFuelID() {
        return fuelID;
    }

    public void setFuelID(int fuelID) {
        this.fuelID = fuelID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(int fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String toString(){
        return "Available [ID = "+ fuelID +"Fuel Type ="+ fuelType +"Fuel Capacity ="+ fuelQuantity;
    }
}
