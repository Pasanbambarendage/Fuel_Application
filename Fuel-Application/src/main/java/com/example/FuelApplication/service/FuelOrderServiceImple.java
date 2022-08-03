package com.example.FuelApplication.service;

import com.example.FuelApplication.config.KafkaTopicConfig;
import com.example.FuelApplication.model.FuelOrder;
import com.example.FuelApplication.repository.FuelOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FuelOrderServiceImple implements FuelOrderService {

    @Autowired
    FuelOrderRepo fuelOrderRepo;

    @Autowired
    KafkaTemplate<String, FuelOrder> kafkaTemplate;

    @Override
    public ResponseEntity<FuelOrder> saveOrder(FuelOrder fuelOrder) {
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(2000);

        try {
            fuelOrder.setOrderID(randomNumber);
            //kafkaTemplate.send(KafkaTopicConfig.MESSAGE_TOPIC, fuelOrder);
            fuelOrderRepo.save(fuelOrder);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(fuelOrder);
    }

    @Override
    public ResponseEntity<List<FuelOrder>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(fuelOrderRepo.findAll());
    }

    @Override
    public ResponseEntity<List<FuelOrder>> getOrder(int shedId) {
        return ResponseEntity.status(HttpStatus.OK).body(fuelOrderRepo.findByShedId(shedId));
    }

    @Override
    public ResponseEntity<FuelOrder> orderReceived(int shedId, String status) {
        Optional<FuelOrder> orderNo = fuelOrderRepo.findById(shedId);
        if(orderNo.isPresent()) {
            FuelOrder order = orderNo.get();
            order.setStatus(status);

            fuelOrderRepo.save(order);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
