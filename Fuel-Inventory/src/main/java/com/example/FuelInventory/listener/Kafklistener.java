package com.example.FuelInventory.listener;

import com.example.FuelApplication.model.FuelOrder;
import com.example.FuelInventory.service.FuelAvailableService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Kafklistener {

    @Autowired
    FuelAvailableService fuelavailableservice;

    @KafkaListener(topics = "order_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<FuelOrder> list){

        String value = String.valueOf(list);
        int orderId =0;
        String fuelType ="";
        String fuelStatus ="";
        int fuelCapacity =0;

        ObjectMapper objectMapper = new ObjectMapper();
        try{
            List<FuelOrder> orders = objectMapper.readValue(value, new TypeReference<List<FuelOrder>>() {});
            for(FuelOrder fuel_order: orders){
                orderId= fuel_order.getOrderID();
                fuelType =fuel_order.getFuelType();
                fuelCapacity = fuel_order.getCapacity();
                fuelStatus = fuel_order.getStatus();
            }

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(fuelavailableservice.getQuantity(orderId,fuelType,fuelCapacity));
    }
}
