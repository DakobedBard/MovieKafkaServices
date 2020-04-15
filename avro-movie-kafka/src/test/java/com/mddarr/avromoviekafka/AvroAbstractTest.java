package com.mddarr.avromoviekafka;

import com.mddarr.avromoviekafka.mock.CustomAvroDeserializer;
import com.mddarr.avromoviekafka.model.events.Event1;
import com.mddarr.avromoviekafka.model.events.Event2;
import com.mddarr.avromoviekafka.services.Producer1;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.test.IntegrationTest;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = {AvroMovieKafkaApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@Category(IntegrationTest.class)
@EmbeddedKafka()
public class AvroAbstractTest {
    @Autowired
    private KafkaProperties kafkaProperties;
    @Autowired
    private EmbeddedKafkaBroker kafkaEmbedded;

    protected Producer<String, Event1> event1Producer;
    protected Producer<String, Event2> event2Producer;

    protected Consumer<String, Event1> event1Consumer;
    protected Consumer<String, Event2> event2Consumer;


    @Before
    public void setUp(){
        Map<String, Object> senderProps = kafkaProperties.buildProducerProperties();

        event1Producer = new KafkaProducer<>(senderProps);
        event2Producer = new KafkaProducer<>(senderProps);

        //consumers used in test code needs to be created like this in code because otherwise it won't work
        Map<String, Object> configs = new HashMap<>(KafkaTestUtils.consumerProps("in-test-consumer", "false", kafkaEmbedded));
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomAvroDeserializer.class);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        configs.put("schema.registry.url", "not-used");

        event1Consumer = new DefaultKafkaConsumerFactory<String, Event1>(configs).createConsumer("in-test-consumer", "10");
        event2Consumer = new DefaultKafkaConsumerFactory<String, Event2>(configs).createConsumer("in-test-consumer", "10");


        kafkaProperties.buildConsumerProperties();
        event1Consumer.subscribe(Lists.newArrayList(Constants.EVENT_1_TOPIC));
        event2Consumer.subscribe(Lists.newArrayList(Constants.EVENT_2_TOPIC));
    }

    @After
    public void reset(){
        event1Consumer.close();
        event2Consumer.close();
    }

}
