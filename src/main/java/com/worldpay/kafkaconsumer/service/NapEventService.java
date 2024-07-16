package com.worldpay.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NapEventService {

    private final Logger logger = LoggerFactory.getLogger(NapEventService.class);

    @Value("${nap.event.service.url}")
    private String napEventServiceUrl;

    @Value("${nap.event.service.enabled}")
    private boolean isEnabled;

    public void sendEvent(Object message) {
        if (isEnabled) {
            // Mock sending event to NAP EVENT SERVICE
            logger.debug("Sending event to NAP EVENT SERVICE: " + message);
            // In real scenario, you would use RestTemplate or WebClient to make the HTTP call
            // RestTemplate restTemplate = new RestTemplate();
            // restTemplate.postForObject(napEventServiceUrl, message, String.class);
        } else {
            logger.debug("NAP EVENT SERVICE is disabled. Event not sent.");
        }
    }
}