package ml.pevgen.mskafkatest.producer.service;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.mskafkatest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class KafkaAvroProducer {

    @Value("${mskafkatest.kafka.avro.topic.name}")
    String topicName;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;


    @Scheduled(fixedRate = 1000)
    public void send() {
        User stockHistory = User.newBuilder().setName("name 1").setAge(123).build();
        ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(topicName, String.valueOf(stockHistory.getName()), stockHistory);
        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }

            @Override
            public void onSuccess(SendResult<String, User> result) {
                System.out.println("Avro message successfully produced");
            }
        });

    }


}
