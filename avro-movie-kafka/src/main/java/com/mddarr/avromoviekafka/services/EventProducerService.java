package com.mddarr.avromoviekafka.services;

import com.mddarr.avromoviekafka.Constants;
import com.mddarr.avromoviekafka.model.events.Event1;
import com.mddarr.avromoviekafka.model.events.Event2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducerService {

    @Autowired
    private KafkaTemplate<String, Event1> kafkaTemplateEvent1;
    @Autowired
    private KafkaTemplate<String, Event2> kafkaTemplateEvent2;
    private static final Logger logger = LoggerFactory.getLogger(EventProducerService.class);

    public void sendEvent1() {
        Event1 event1 = Event1.newBuilder().setName("name").setValue("value").build();
        logger.info("Send event 1 {}", event1);
        kafkaTemplateEvent1.send(Constants.EVENT_1_TOPIC, event1);
    }

    public void sendEvent2() {
        Event2 event1 = Event2.newBuilder().setHits(10).setTimestamp(System.currentTimeMillis()).build();
        logger.info("Send event 2 {}", event1);
        kafkaTemplateEvent2.send(Constants.EVENT_2_TOPIC, event1);
    }
}




