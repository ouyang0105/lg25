package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.cssl.web")
@MapperScan("com.cssl.dao")
@SpringBootApplication
public class MyVoteApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyVoteApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyVoteApplication.class);
    }
}
