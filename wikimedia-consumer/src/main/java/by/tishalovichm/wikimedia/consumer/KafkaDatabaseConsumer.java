package by.tishalovichm.wikimedia.consumer;

import by.tishalovichm.wikimedia.entity.WikimediaData;
import by.tishalovichm.wikimedia.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(KafkaDatabaseConsumer.class);

    private final WikimediaDataRepository repository;

    @KafkaListener(
            topics = "${kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Consumed message: %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setContent(eventMessage);

        repository.save(wikimediaData);
    }

}
