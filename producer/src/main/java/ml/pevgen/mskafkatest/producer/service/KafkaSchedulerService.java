package ml.pevgen.mskafkatest.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaSchedulerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${mskafkatest.kafka.topic.name}")
    private String topicName;

    private int count;

    @Scheduled(fixedRate = 1000)
    public void send() {
        String message = "message " + count++;
        log.info(message);
        kafkaTemplate.send(topicName, message);
    }
}
