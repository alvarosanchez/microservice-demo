package com.nklmish.zuul.demo

import com.ofg.infrastructure.web.correlationid.EnableCorrelationId
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.stereotype.Controller

@SpringBootApplication
@EnableZuulProxy
@Controller
@EnableCorrelationId
class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
