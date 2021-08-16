package com.cssl;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboUserconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboUserconsumerApplication.class, args);
    }

}
