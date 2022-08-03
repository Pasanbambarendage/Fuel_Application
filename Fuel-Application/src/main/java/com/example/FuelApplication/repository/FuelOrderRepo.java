package com.example.FuelApplication.repository;

import com.example.FuelApplication.model.FuelOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelOrderRepo extends MongoRepository <FuelOrder, Integer> {
    List<FuelOrder> findByShedId(int shedId);
}
