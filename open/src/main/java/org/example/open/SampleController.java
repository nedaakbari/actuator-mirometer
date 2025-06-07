//package org.example.open;
//
////import io.micrometer.core.instrument.MeterRegistry;
//import io.opentelemetry.api.trace.Span;
//import io.opentelemetry.api.trace.Tracer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class SampleController {
//
//    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
//
//    @Autowired
//    private MeterRegistry meterRegistry;
//
//    @Autowired
//    private Tracer tracer;
//
//    @GetMapping("/sample")
//    public String sampleEndpoint() {
//
//        // تریسینگ (Tracing)
//        Span span = tracer.spanBuilder("sample-endpoint-span").startSpan();
//        try {
//            // ارسال لاگ
//            logger.info("Sample endpoint called!");
//
//            // ثبت متریک سفارشی
//            meterRegistry.counter("my.custom.metric", "endpoint", "/sample").increment();
//
//            return "Sample response";
//        } finally {
//            span.end();
//        }
//    }
//}
