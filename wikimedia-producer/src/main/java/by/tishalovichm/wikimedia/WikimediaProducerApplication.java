package by.tishalovichm.wikimedia;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class WikimediaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikimediaProducerApplication.class, args);
	}

}
