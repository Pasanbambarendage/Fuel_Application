package com.example.FuelInventory.service;

import com.example.FuelInventory.model.FuelAvailable;
import com.example.FuelInventory.repository.FuelAvailableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class FuelAvailableServiceImpl implements FuelAvailableService {

    @Autowired
    FuelAvailableRepo fuelavailablerepo;

    @Override
    public ResponseEntity<FuelAvailable> AvailableStock(FuelAvailable fuel_available) {
        int Fuel_ID;
        Random random = new Random();
        Fuel_ID=random.nextInt(100);

        try {
            fuel_available.setFuelID(Fuel_ID);
            fuelavailablerepo.save(fuel_available);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.OK).body(fuel_available);
    }

    @Override
    public ResponseEntity<FuelAvailable> UpdateStock(int id, FuelAvailable fuel_available) {
        Optional<FuelAvailable> fuelID = fuelavailablerepo.findById(id);
        if (fuelID.isPresent()){
            FuelAvailable fuelavailable=fuelID.get();
            fuelavailable.setFuelQuantity(fuel_available.getFuelQuantity());
            fuelavailablerepo.save(fuelavailable);

            return ResponseEntity.status(HttpStatus.OK).body(fuelavailable);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public FuelAvailable getQuantity(int order_Id, String fuel_type, int fuel_capacity) {
        FuelAvailable byFuelType = fuelavailablerepo.findByFuelType(fuel_type);
        int availablecapacity = byFuelType.getFuelQuantity();
        String status ="Allocated";
        int Fuel_Balance = availablecapacity - fuel_capacity;
        byFuelType.setFuelQuantity(Fuel_Balance);
        AvailableStock(byFuelType);

        return byFuelType;

    }
}
