package org.example.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {//health, metrics, info, dump, env, etc
        SpringApplication.run(SampleApplication.class, args);
    }

}
