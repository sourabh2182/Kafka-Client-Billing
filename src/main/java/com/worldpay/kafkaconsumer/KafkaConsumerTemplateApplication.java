package com.worldpay.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.worldpay.kafkaconsumer")
public class KafkaConsumerTemplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaConsumerTemplateApplication.class, args);

        // Explicitly run the PropertyValidationService
        PropertyValidationService validationService = context.getBean(PropertyValidationService.class);
        validationService.run(args);

        // Ensure the application shuts down properly
        SpringApplication.exit(context);
    }

}
