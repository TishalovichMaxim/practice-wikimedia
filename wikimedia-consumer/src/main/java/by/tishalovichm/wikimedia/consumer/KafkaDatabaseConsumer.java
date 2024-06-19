package by.tishalovichm.wikimedia.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Consumed message: %s", eventMessage));
    }

}
