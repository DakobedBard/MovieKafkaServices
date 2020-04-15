package com.mddarr.avromoviekafka.event;

import com.mddarr.avromoviekafka.AvroAbstractTest;
import com.mddarr.avromoviekafka.services.EventProducerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageProducerTest extends AvroAbstractTest {
    @Autowired
    private EventProducerService eventProducer;

    @Test
    public void send_event1(){

    }

    @Test
    public void send_event2(){

    }
}
