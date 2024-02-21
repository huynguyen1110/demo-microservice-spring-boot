package com.example.bookservice.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {

        boolean isServiceHealthy = checkHealthService();
        if (isServiceHealthy) {
            return Health.up().build();
        }else {
            return Health.down().withDetail("err", "err").build();
        }
    }

    private boolean checkHealthService() {
        return true;
    }
}
