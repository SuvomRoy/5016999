package com.example.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter bookRequestsCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.bookRequestsCounter = meterRegistry.counter("custom.book_requests_total");
    }

    public void incrementBookRequests() {
        this.bookRequestsCounter.increment();
    }
}
