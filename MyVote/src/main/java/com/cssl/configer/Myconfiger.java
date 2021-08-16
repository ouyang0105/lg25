package com.cssl.configer;

import com.cssl.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfiger implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/js/**","/css/**","/images/**","/");

    }
}
