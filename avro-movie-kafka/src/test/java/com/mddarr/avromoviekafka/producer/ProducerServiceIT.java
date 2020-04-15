package com.mddarr.avromoviekafka.producer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mddarr.avromoviekafka.model.UserUpdateEvent;
import com.mddarr.avromoviekafka.services.UserProducerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest()
public class ProducerServiceIT {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceIT.class);
    @Autowired
    private UserProducerService userProducerService;
    private static String TOPIC = "users";

    private KafkaMessageListenerContainer<String, UserUpdateEvent> container;

    private BlockingQueue<ConsumerRecord<String, String>> consumerRecords;

    @ClassRule
    public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1,true, TOPIC);

    @Before
    public void setUp(){
        consumerRecords = new LinkedBlockingDeque<>();
        ContainerProperties containerProperties = new ContainerProperties(TOPIC);
        Map<String, Object> consumerProperties = KafkaTestUtils.consumerProps(
                "sender", "false",embeddedKafka.getEmbeddedKafka());
        DefaultKafkaConsumerFactory<String, UserUpdateEvent> consumer = new DefaultKafkaConsumerFactory<>(consumerProperties);

        container = new KafkaMessageListenerContainer<>(consumer, containerProperties);

        container.setupMessageListener((MessageListener<String, String>) record -> {
            LOGGER.debug("Listened message'{}'", record.toString());
        });

        container.start();
        ContainerTestUtils.waitForAssignment(container, embeddedKafka.getEmbeddedKafka().getPartitionsPerTopic());

    }

    @After
    public void tearDown(){
        container.stop();
    }

    @Test
    public void test_user_update_event_producer() throws InterruptedException {
        UserUpdateEvent userUpdateEvent = new UserUpdateEvent("mddarr","signup");
        userProducerService.send(userUpdateEvent);

        ConsumerRecord<String, String> received = consumerRecords.poll(10, TimeUnit.SECONDS);

        ObjectMapper mapper = new ObjectMapper();

    }

}
