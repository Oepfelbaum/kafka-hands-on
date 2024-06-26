package com.oepfelbaum.training.kafka.sensorproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SensorproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensorproducerApplication.class, args);
	}

}
