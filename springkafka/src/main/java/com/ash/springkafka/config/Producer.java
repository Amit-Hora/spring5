package com.ash.springkafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.ash.springkafka.model.Sensor;

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
	
	public <T> void sendData(String key,T o) {
		this.kafkaTemplate.send("test",((Sensor) o).getId()+"",o);
	}

	

}
