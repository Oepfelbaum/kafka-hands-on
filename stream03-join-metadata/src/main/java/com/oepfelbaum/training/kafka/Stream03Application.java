package com.oepfelbaum.training.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class Stream03Application {

    public static void main(String[] args) {
        SpringApplication.run(Stream03Application.class, args);
    }
}
