package ml.pevgen.mskafkatest.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${mskafkatest.kafka.topic.name}")
    private String topicName;

    public void send(String message) {
        kafkaTemplate.send(topicName, message);
    }
}
