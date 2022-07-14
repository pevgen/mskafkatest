package ml.pevgen.mskafkatest.producer;

import ml.pevgen.mskafkatest.producer.service.KafkaProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProducerApplication.class, args);
        KafkaProducerService service = context.getBean(KafkaProducerService.class);
        service.send("temp message: " + LocalDateTime.now());
    }

}
