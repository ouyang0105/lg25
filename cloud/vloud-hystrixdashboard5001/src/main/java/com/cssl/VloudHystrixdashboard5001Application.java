package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class VloudHystrixdashboard5001Application {

    public static void main(String[] args) {
        SpringApplication.run(VloudHystrixdashboard5001Application.class, args);
    }

}
