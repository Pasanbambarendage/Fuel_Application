package com.example.FuelInventory.service;

import com.example.FuelInventory.model.FuelAvailable;
import org.springframework.http.ResponseEntity;

public interface FuelAvailableService {
    public ResponseEntity<FuelAvailable> AvailableStock(FuelAvailable fuel_available);

    public ResponseEntity<FuelAvailable> UpdateStock(int id, FuelAvailable fuel_available);

    public FuelAvailable getQuantity(int orderId, String fueltype, int fuelcapacity);
}
