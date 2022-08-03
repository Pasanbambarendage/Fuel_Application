package com.example.FuelInventory.repository;

import com.example.FuelInventory.model.FuelAvailable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelAvailableRepo extends MongoRepository<FuelAvailable,Integer> {

    FuelAvailable findByFuelType(String fuelType);
}
