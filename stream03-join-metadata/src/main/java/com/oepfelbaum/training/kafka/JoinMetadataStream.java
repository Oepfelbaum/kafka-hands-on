package com.oepfelbaum.training.kafka;

import com.oepfelbaum.training.kafka.sensorproducer.SensorMeasurement;
import com.oepfelbaum.training.kafka.sensorproducer.SensorMeasurementEnriched;
import com.oepfelbaum.training.kafka.sensorproducer.SensorMetadata;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JoinMetadataStream {
    private static final Logger log = LoggerFactory.getLogger(JoinMetadataStream.class);

    @Bean
    public KStream<String, SensorMeasurement> kStream(final StreamsBuilder builder) {
        final GlobalKTable<String, SensorMetadata> table = builder.globalTable("metadata");

        final KStream<String, SensorMeasurement> stream = builder.stream("sensor");

        stream
                .join(table,
                        (key, value) -> key,
                        this::createSensorMeasurementEnriched
                )
                .peek((key, value) -> log.info("Writing enriched Sensor event to new topic {}", value))
                .to("sensor-with-metadata");

        return stream;
    }

    private SensorMeasurementEnriched createSensorMeasurementEnriched(final SensorMeasurement sensorMeasurement, final SensorMetadata sensorMetadata) {
        return new SensorMeasurementEnriched(
                sensorMeasurement.getSensorId(),
                sensorMeasurement.getType(),
                sensorMeasurement.getUnit(),
                sensorMeasurement.getValue(),
                sensorMetadata.getModel()
        );
    }

}
