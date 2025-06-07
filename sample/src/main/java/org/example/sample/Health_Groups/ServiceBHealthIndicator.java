package org.example.sample.Health_Groups;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceBHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // منطق بررسی سلامت سرویس B
        return Health.down().withDetail("service", "B").build();
    }
}