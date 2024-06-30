package com.oepfelbaum.training.kafka;

import com.oepfelbaum.training.kafka.sensorproducer.SensorMeasurement;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemperatureStream {
    private static final Logger log = LoggerFactory.getLogger(TemperatureStream.class);

    @Bean
    public KStream<String, SensorMeasurement> kStream(StreamsBuilder builder) {
        final KStream<String, SensorMeasurement> stream = builder.stream("sensor");

        stream
                .peek((key, value) -> log.info("Processing event {}", value))
                .filter((key, value) -> "Temperature".contentEquals(value.getType()))
                .peek((key, value) -> log.info("Writing event to new topic {}", value))
                .to("temperature");

        return stream;
    }
}
