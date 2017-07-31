package com.endava.numbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class NumbersApplication {
    @Autowired
    private NumberController controller;
    private static final Logger log= LoggerFactory.getLogger(NumbersApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(NumbersApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            NumberInput number = restTemplate.getForObject("https://qrng.anu.edu.au/API/jsonI.php?length=3&type=uint8", NumberInput.class);
            log.info(number.getData()[0].toString());
            controller.addNumber(number);
        };
    }
}
