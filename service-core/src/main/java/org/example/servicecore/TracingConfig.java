package org.example.servicecore;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {

    @Bean
    public Tracer tracer() {
        return GlobalOpenTelemetry.getTracer("com.example.observability-demo");// تو Jaeger یا Grafana Tempo یا هر backend دیگه، این اسم تو داده‌ها دیده می‌شه.
    }
    //opentelemetry-spring-boot-starter خودش auto-instrumentation انجام می‌ده (برای کنترلرها و غیره)
    //اما اگر بخوای خودت دستی Tracer تزریق کنی، باید beanش رو صراحتاً تعریف کنی

    @Bean
    public MeterRegistry meterRegistry() {
        return new SimpleMeterRegistry();
    }
}
