package com.amdocs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Hooks;

@SpringBootConfiguration
@EnableAutoConfiguration
public class SpringGateway {

    public static void main(String[] args) {
        SpringApplication.run(SpringGateway.class, args);
    }

    @Bean
    @ConditionalOnProperty(prefix = "apigw.tracing", name = "enableAutomaticContextPropagation", matchIfMissing = true)
    public void enableAutomaticContextPropagation() {
        Hooks.enableAutomaticContextPropagation();
    }

}

