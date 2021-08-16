package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@MapperScan("com.cssl.dao")
@EnableEurekaClient
@SpringBootApplication
public class CloudUsersprovider7001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudUsersprovider7001Application.class, args);
    }

}
