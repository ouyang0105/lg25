package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer6001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer6001Application.class, args);
    }

}
