package com.ash.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ash.springkafka.config.Producer;
import com.ash.springkafka.model.Sensor;

@SpringBootApplication
public class SpringkafkaApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringkafkaApplication.class, args);
		Sensor sensor = new Sensor(101,20, -30, 120);
		Producer producer = ctx.getBean(Producer.class);
		producer.getKafkaTemplate().send("test",sensor.getId()+"",sensor);
	}

}
