package ml.pevgen.mskafkatest.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
//@Service
public class KafkaConsumerService {

    private static final String TOPIC_NAME = "${mskafkatest.kafka.topic.name}";

    @KafkaListener(topics = TOPIC_NAME)
    public void consumeMessage(String message) {
        log.info("message consumed {}", message);
    }
}
