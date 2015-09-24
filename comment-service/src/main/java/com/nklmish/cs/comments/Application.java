package com.nklmish.cs.comments;

import com.ofg.infrastructure.web.correlationid.EnableCorrelationId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCorrelationId
class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
