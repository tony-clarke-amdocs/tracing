package com.amdocs.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Microservice {

    private static final Logger log = LoggerFactory.getLogger(Microservice.class);

    public static void main(String[] args) {
        SpringApplication.run(Microservice.class, args);
    }

    // add a spring mvc rest controller
     @RestController
     public class HelloController {
         @RequestMapping("/trace")
         // access the response headers
         public String index(@RequestHeader HttpHeaders headers) {
//             log.info("Just some message that when logged will include trace IDs");
             return "Greetings from Spring Boot!";
         }
     }
}
