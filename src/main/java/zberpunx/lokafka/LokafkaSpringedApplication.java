package zberpunx.lokafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

@SpringBootApplication
public class LokafkaSpringedApplication {
    public static void main(String[] args) {
        SpringApplication.run(LokafkaSpringedApplication.class, args);
    }

    @Bean
    EmbeddedKafkaBroker ekb(@Value("${zkPort:2181}") int zkPort,
                            @Value("${kafkaPort:9092}") int kafkaPort) {
        return new EmbeddedKafkaBroker(1)
                .zkPort(zkPort)
                .kafkaPorts(kafkaPort);
    }
}
