package com.example.FuelApplication.service;

import com.example.FuelApplication.model.FuelOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface FuelOrderService {


    ResponseEntity<FuelOrder> saveOrder(FuelOrder fuelOrder);

    ResponseEntity<List<FuelOrder>> getAllOrders();


    ResponseEntity<List<FuelOrder>> getOrder(int shedId);

    ResponseEntity<FuelOrder> orderReceived(int shedId, String status);
}
