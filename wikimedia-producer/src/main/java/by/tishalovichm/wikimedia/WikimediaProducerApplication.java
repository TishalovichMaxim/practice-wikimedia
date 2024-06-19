package by.tishalovichm.wikimedia;

import by.tishalovichm.wikimedia.producer.WikimediaChangesProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class WikimediaProducerApplication implements CommandLineRunner {

	private final WikimediaChangesProducer wikimediaChangesProducer;

	public static void main(String[] args) {
		SpringApplication.run(WikimediaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		wikimediaChangesProducer.sendMessage();
	}

}
