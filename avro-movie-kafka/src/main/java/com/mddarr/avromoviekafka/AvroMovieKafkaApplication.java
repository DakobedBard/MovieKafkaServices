package com.mddarr.avromoviekafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AvroMovieKafkaApplication {

	@Value("${topic_name}")
	private String topicName;

	@Value("${topic_partitions_num}")
	private Integer partitions;

	@Value("${topic_partions_replication_factor}")
	private short replicationFactor;

	public static void main(String[] args) {
		SpringApplication.run(AvroMovieKafkaApplication.class, args);
	}

	@Bean
	NewTopic moviesTopic() {
		return new NewTopic(topicName, partitions, replicationFactor);
	}
}
