package com.example.FuelInventory.controller;

import com.example.FuelInventory.model.FuelAvailable;
import com.example.FuelInventory.service.FuelAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class FuelAvailableController {

    @Autowired
    FuelAvailableService fuelavailableservice;

    @PostMapping("/savestock")
    public ResponseEntity<FuelAvailable> savestock(@RequestBody FuelAvailable fuel_available){
        return fuelavailableservice.AvailableStock(fuel_available);
    }

    @RequestMapping(value = "/updatestock/{Id}", method = RequestMethod.PUT)
    public ResponseEntity<FuelAvailable>updateStock(@PathVariable int Id, @RequestBody FuelAvailable fuelavailable){
        return fuelavailableservice.UpdateStock(Id, fuelavailable);
    }
}
