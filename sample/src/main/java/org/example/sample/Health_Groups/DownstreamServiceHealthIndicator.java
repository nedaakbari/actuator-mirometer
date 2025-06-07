package org.example.sample.Health_Groups;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DownstreamServiceHealthIndicator implements HealthIndicator {//http://localhost:8080/actuator/health

    @Override
    public Health health() {
        try {
            // بررسی سلامت سرویس پایین‌دستی
            boolean isServiceUp = checkDownstreamServiceHealth();
            if (isServiceUp) {
                return Health.up().withDetail("service", "DownstreamService").build();
            } else {
                return Health.down().withDetail("error", "Service is down").build();
            }
        } catch (Exception ex) {
            return Health.down(ex).build();
        }
    }

    private boolean checkDownstreamServiceHealth() {
        // در اینجا می‌توانید از RestTemplate یا HttpClient برای بررسی سلامت سرویس استفاده کنید
        // به عنوان مثال:
        // ResponseEntity<String> response = restTemplate.getForEntity("http://downstream-service/health", String.class);
        // return response.getStatusCode().is2xxSuccessful();
        return true; // فرض بر این است که سرویس سالم است
    }
}
