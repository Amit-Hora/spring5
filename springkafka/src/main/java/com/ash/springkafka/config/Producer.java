package com.ash.springkafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class Producer {
 
   
	private final KafkaTemplate kafkaTemplate;

	@Autowired
	public Producer(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public KafkaTemplate getKafkaTemplate() {
		return kafkaTemplate;
	}
	
	

}
