package com.worldpay.kafkaconsumer.model;

import com.fasterxml.jackson.databind.JsonNode;

public class GenericMessage {
    private JsonNode payload;

    public JsonNode getPayload() {
        return payload;
    }

    public void setPayload(JsonNode payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "GenericMessage{" +
                "payload=" + payload +
                '}';
    }
}
