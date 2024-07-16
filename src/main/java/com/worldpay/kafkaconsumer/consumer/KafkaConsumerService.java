package com.worldpay.kafkaconsumer.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.worldpay.kafkaconsumer.service.NapEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Autowired
    private NapEventService napEventService;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(JsonNode message) {
        logger.debug(String.format("Consumed message: %s", message.toString()));
        // Send the event to the mock NAP EVENT SERVICE
        napEventService.sendEvent(message);
    }
}
