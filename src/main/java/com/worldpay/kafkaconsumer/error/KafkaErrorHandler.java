package com.worldpay.kafkaconsumer.error;

import com.worldpay.kafkaconsumer.consumer.KafkaConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

@Component
public class KafkaErrorHandler implements ErrorHandler {

    private final Logger logger = LoggerFactory.getLogger(KafkaErrorHandler.class);
    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> record) {
        if (thrownException instanceof ListenerExecutionFailedException) {
            ListenerExecutionFailedException failedException = (ListenerExecutionFailedException) thrownException;
            // Implement retry logic or error handling here
            logger.error("Error processing message: {}", record.value(), failedException.fillInStackTrace());
            failedException.printStackTrace();
        }
    }
}
