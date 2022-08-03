package com.example.FuelApplication.controller;


import com.example.FuelApplication.model.FuelOrder;
import com.example.FuelApplication.service.FuelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class FuelOderController {

    @Autowired
    FuelOrderService fuelOrderService;

    @PostMapping("/placeorder")
    public ResponseEntity<FuelOrder> PlaceOrder (@RequestBody FuelOrder fuelOrder){
        return fuelOrderService.saveOrder(fuelOrder);
    }

    @GetMapping("/getallorders")
    public ResponseEntity<List<FuelOrder>> GetAllOrders(){
        return fuelOrderService.getAllOrders();
    }

    @GetMapping("/{shedId}")
    public ResponseEntity<List<FuelOrder>> GetOrder(@PathVariable int shedId){
        return fuelOrderService.getOrder(shedId);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<FuelOrder> OrderReceived (@PathVariable int shedId, @PathVariable String status){
        return fuelOrderService.orderReceived(shedId,status);
    }



}
