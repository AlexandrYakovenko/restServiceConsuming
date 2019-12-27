package rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import rest.service.entity.Exhibition;

import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
public class RestApplication {
    private static final Logger logger = LoggerFactory.getLogger(RestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Exhibition exhibition = restTemplate.getForObject(
                    "http://localhost:8080/exhibitions/1", Exhibition.class
            );
            logger.info(Objects.requireNonNull(exhibition).toString());
        };
    }
}
