package com.mddarr.avromoviekafka.services;

import com.mddarr.avromoviekafka.model.UserUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducerService {
    private static final String TOPIC ="UpdateUserEvent";


    private final KafkaTemplate<String, UserUpdateEvent> userKafkaTemplate;

    @Autowired
    public UserProducerService(KafkaTemplate<String, UserUpdateEvent> kafkaTemplate){
        this.userKafkaTemplate = kafkaTemplate;
    }

    public void send(UserUpdateEvent updateEvent){
        userKafkaTemplate.send(TOPIC,updateEvent);
    }

}

