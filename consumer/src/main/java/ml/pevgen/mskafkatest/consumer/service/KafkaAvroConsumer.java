package ml.pevgen.mskafkatest.consumer.service;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.mskafkatest.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaAvroConsumer {

    private static final String TOPIC_NAME_AVRO = "${mskafkatest.kafka.avro.topic.name}";

    @KafkaListener(topics = TOPIC_NAME_AVRO)
    public void consumeMessage(User message) {
        log.info("message consumed {}", message);
    }
}
