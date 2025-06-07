package org.example.serviceapi;

import com.example.core.AuditLogger;
import io.micrometer.core.instrument.MeterRegistry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiController {
    private final Tracer tracer;
    private final MeterRegistry meterRegistry;
    private final AuditLogger auditLogger;

    @GetMapping("/ping")
    public String ping() {
        Span span = tracer.spanBuilder("ping-endpoint").startSpan();
        try {
            log.info("Handling /ping request");
            auditLogger.audit("User called /ping");
            meterRegistry.counter("custom.ping.calls").increment();
            return "pong";
        } finally {
            span.end();
        }
    }
}
