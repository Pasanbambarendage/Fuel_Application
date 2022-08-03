package com.example.FuelApplication.config;

import com.example.FuelApplication.model.FuelOrder;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducer {

    @Value("localhost:9092")
    private String boostrapServer;

    public Map<String,Object> Config_Producer(){
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServer);
        orderMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        orderMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return orderMap;
    }

    @Bean
    public ProducerFactory<String, FuelOrder> producerFactory(){
        return new DefaultKafkaProducerFactory<>(Config_Producer());
    }

    @Bean
    public KafkaTemplate<String, FuelOrder> kafkaTemplate(ProducerFactory<String, FuelOrder> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
