package org.example.servicecore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class AuditLogger {
    public void audit(String message) {
        log.info("[AUDIT] {}", message);
    }
}