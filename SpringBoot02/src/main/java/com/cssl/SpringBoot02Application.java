package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cssl.dao")
@SpringBootApplication
public class SpringBoot02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02Application.class, args);
    }

}
