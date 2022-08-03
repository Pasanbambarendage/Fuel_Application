package com.example.FuelInventory.repository;

import com.example.FuelInventory.model.FuelReserved;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelReservedRepo extends MongoRepository<FuelReserved,Integer> {
}
