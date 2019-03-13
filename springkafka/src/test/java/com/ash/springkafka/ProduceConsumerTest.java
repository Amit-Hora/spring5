package com.ash.springkafka;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.test.context.junit4.SpringRunner;

import com.ash.springkafka.config.Producer;
import com.ash.springkafka.model.Sensor;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EmbeddedKafka
public class ProduceConsumerTest {
	/*@Autowired
	private EmbeddedKafka kafkaEmbedded;*/
/*	@Autowired
	private KafkaMessageListenerContainer<String, String> container;*/

	private static String SENDER_TOPIC = "test";
	 @Autowired
	  private Producer producer;
	 
	private BlockingQueue<String> records=new LinkedBlockingQueue<>();;
	private static final Logger LOGGER =
		      LoggerFactory.getLogger(ProduceConsumerTest.class);
	

/*	  @ClassRule
	  public static EmbeddedKafkaRule embeddedKafka =
	      new EmbeddedKafkaRule(1, true, SENDER_TOPIC);*/


	  @KafkaListener(topics = "test")
	    public void receive(@Payload String message,
	                        @Headers MessageHeaders headers) {
		  records.add(message);
	        System.out.println("Size..." +records.size());
		  LOGGER.info("received message in test ='{}'", message);
	        headers.keySet().forEach(key -> LOGGER.info("{}: {}", key, headers.get(key)));

	    }
	  /*@Before
	  public void setUp() throws Exception {
	  records = new LinkedBlockingQueue<>();
	  }*/

	  @Test
	  public void testSend() throws InterruptedException {
	    // send the message
//	    ProducerRecord<String, String> greeting = new ProducerRecord<String, String>("test","Hello Spring Kafka Sender!");
//	    producer.send(greeting);
		  System.out.println("Strating this **************");
		  Sensor sensor = new Sensor(101, 20, -30, 120);
		  producer.sendData(sensor.getId()+"", sensor);
	    // check that the message was received
	    String received =
	        records.poll(10, TimeUnit.SECONDS);
	    
	    System.out.println("Received ..... "+ records.size());
	    // Hamcrest Matchers to check the value
	    assertEquals("{\"id\":101,\"lat\":20,\"lon\":-30,\"tmp\":120}",received);
//	    System.out.println(received.value());
	   /* assertThat(received, hasValue(greeting.value()));
	    // AssertJ Condition to check the key
	    assertThat(received).has(key(null));*/
	  }
	
	
}
