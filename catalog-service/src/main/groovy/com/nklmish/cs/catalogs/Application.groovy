package com.nklmish.cs.catalogs

import com.ofg.infrastructure.web.correlationid.EnableCorrelationId
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableCorrelationId
class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}
