package com.kafkaconsumer.models.event;

import java.util.Arrays;

public enum Event {
    SSE_EVENT("sse_event"), //
    KAFKA_EVENT("kafka_event"), //
    HANDSHAKE_EVENT("handshake_event"), //
    UNDEFINED("undefined");

    private final String name;

    Event(String name) {
        this.name = name;
    }

    public final String getEmitterEventName() {
        return this.name;
    }

    public static Event parseEvent(String event) {
        return Arrays.stream(values()) //
                .filter(ev -> ev.name().equalsIgnoreCase(event)) //
                .findFirst() //
                .orElseThrow(() -> new IllegalArgumentException("Event type not found!"));
    }
}
