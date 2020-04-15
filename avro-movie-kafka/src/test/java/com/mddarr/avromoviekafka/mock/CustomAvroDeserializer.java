package com.mddarr.avromoviekafka.mock;

import com.mddarr.avromoviekafka.model.events.Event1;
import com.mddarr.avromoviekafka.model.events.Event2;
import io.confluent.kafka.schemaregistry.client.MockSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.avro.Schema;
import com.mddarr.avromoviekafka.Constants;

public class CustomAvroDeserializer extends KafkaAvroDeserializer {
    @Override
    public Object deserialize(String topic, byte[] bytes) {
        if (topic.equals(Constants.EVENT_1_TOPIC)) {
            this.schemaRegistry = getMockClient(Event1.SCHEMA$);
        }
        if (topic.equals(Constants.EVENT_2_TOPIC)) {
            this.schemaRegistry = getMockClient(Event2.SCHEMA$);
        }

        return super.deserialize(topic, bytes);
    }

    private static SchemaRegistryClient getMockClient(final Schema schema$) {
        return new MockSchemaRegistryClient() {
            @Override
            public synchronized Schema getById(int id) {
                return schema$;
            }
        };
    }
}
