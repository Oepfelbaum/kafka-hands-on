package com.oepfelbaum.training.kafka.sensorproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SensorProducer {
    private static final Logger log = LoggerFactory.getLogger(SensorProducer.class);
    private final KafkaTemplate<String, SensorMeasurement> kafkaTemplate;

    @Value("${sensor.topic}")
    private String TOPIC;

    @Value("${sensor.id}")
    private String SENSOR_ID;

    @Value("${sensor.type}")
    private String SENSOR_TYPE;

    @Value("${sensor.unit}")
    private String SENSOR_UNIT;

    @Value("${sensor.min-value}")
    private double MIN_VALUE;

    @Value("${sensor.max-value}")
    private double MAX_VALUE;

    public SensorProducer(KafkaTemplate<String, SensorMeasurement> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedDelayString = "${sensor.interval-ms}")
    public void sendSensorMeasurement() {
        final SensorMeasurement sensorMeasurement = createSensorMeasurement();
        log.info("Sending message sensor={} topic={} value={}", SENSOR_ID, TOPIC, sensorMeasurement);
        kafkaTemplate.send(TOPIC, SENSOR_ID, sensorMeasurement);
    }

    private SensorMeasurement createSensorMeasurement() {
        final SensorMeasurement sensorMeasurement = new SensorMeasurement();
        sensorMeasurement.setSensorId(SENSOR_ID);
        sensorMeasurement.setType(SENSOR_TYPE);
        sensorMeasurement.setUnit(SENSOR_UNIT);
        sensorMeasurement.setValue(randomDouble(MIN_VALUE, MAX_VALUE));
        return sensorMeasurement;
    }

    private static double randomDouble(final double min, final double max) {
        double randomValue = min + (max - min) * new Random().nextDouble();
        return Math.round(randomValue * 10.0) / 10.0;
    }
}
