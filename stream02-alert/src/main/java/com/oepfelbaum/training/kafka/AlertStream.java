package com.oepfelbaum.training.kafka;

import com.oepfelbaum.training.kafka.sensorproducer.SensorMeasurement;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertStream {
    private static final Logger log = LoggerFactory.getLogger(AlertStream.class);

    @Bean
    public KStream<String, SensorMeasurement> kStream(StreamsBuilder builder) {
        final KStream<String, SensorMeasurement> stream = builder.stream("temperature");

        stream
                .peek((key, value) -> log.info("Processing event {}", value))
                .filter((key, value) -> value.getValue() >= 80.0)
                .peek((key, value) -> log.info("Writing Alert event to new topic {}", value))
                .to("alert");

        return stream;
    }
}
