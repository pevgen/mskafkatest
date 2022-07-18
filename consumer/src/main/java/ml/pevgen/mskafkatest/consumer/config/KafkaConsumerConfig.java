package ml.pevgen.mskafkatest.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${mskafkatest.kafka.topic.name}")
    private String topicName;

}
