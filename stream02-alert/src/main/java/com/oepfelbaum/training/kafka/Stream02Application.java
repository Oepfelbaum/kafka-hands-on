package com.oepfelbaum.training.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class Stream02Application {

    public static void main(String[] args) {
        SpringApplication.run(Stream02Application.class, args);
    }
}
