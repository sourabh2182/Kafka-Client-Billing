package com.worldpay.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PropertyValidationService implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(PropertyValidationService.class);

    private final Environment environment;

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Autowired
    public PropertyValidationService(Environment environment) {
        this.environment = environment;
    }

    public void validateProperties() {
        logger.debug("Bootstrap Servers: " + bootstrapServers);
    }

    @Override
    public void run(String... args) {
        // Print the resolved properties
        logger.debug("Bootstrap Servers: " + environment.getProperty("spring.kafka.consumer.bootstrap-servers"));
        logger.debug("Group ID: " + environment.getProperty("spring.kafka.consumer.group-id"));
        logger.debug("Auto Offset Reset: " + environment.getProperty("spring.kafka.consumer.auto-offset-reset"));
        logger.debug("Key Deserializer: " + environment.getProperty("spring.kafka.consumer.key-deserializer"));
        logger.debug("Value Deserializer: " + environment.getProperty("spring.kafka.consumer.value-deserializer"));
        logger.debug("Topic: " + environment.getProperty("spring.kafka.consumer.topic"));
    }

    @PostConstruct
    public void init() {
        logger.debug("Bootstrap Servers in post construct: " + bootstrapServers);
    }
}