package org.example.sample.Health_Groups;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceAHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // منطق بررسی سلامت سرویس A
        return Health.up().withDetail("service", "A").build();
    }
}
