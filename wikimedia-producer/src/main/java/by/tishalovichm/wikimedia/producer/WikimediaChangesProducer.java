package by.tishalovichm.wikimedia.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class WikimediaChangesProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final EventHandler eventHandler;

    @Value("${wikimedia.uri}")
    private String wikimediaUri;

    public void sendMessage() {
        EventSource.Builder builder = new EventSource.Builder(
                eventHandler, URI.create(wikimediaUri)
        );

        try (EventSource eventSource = builder.build();) {
            eventSource.start();
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
