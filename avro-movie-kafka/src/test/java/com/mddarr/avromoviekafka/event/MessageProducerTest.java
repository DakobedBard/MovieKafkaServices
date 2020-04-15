package com.mddarr.avromoviekafka.event;

import com.mddarr.avromoviekafka.AvroAbstractTest;
import com.mddarr.avromoviekafka.Constants;
import com.mddarr.avromoviekafka.model.events.Event1;
import com.mddarr.avromoviekafka.services.EventProducerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import static org.assertj.core.api.Assertions.assertThat;


public class MessageProducerTest extends AvroAbstractTest {
    @Autowired
    private EventProducerService eventProducer;

    @Test
    public void send_event1(){
        eventProducer.sendEvent1();
        ConsumerRecord<String, Event1> singleRecord = KafkaTestUtils.getSingleRecord(event1Consumer, Constants.EVENT_1_TOPIC);
        assertThat(singleRecord).isNotNull();
    }

    @Test
    public void send_event2(){

    }
}
