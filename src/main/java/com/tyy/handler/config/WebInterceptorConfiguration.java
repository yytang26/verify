package com.tyy.handler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:tyy
 * @date:2021/5/10
 */

@Configuration
public class WebInterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(new WebInterceptor1());
        interceptorRegistration1.addPathPatterns("/**");

        InterceptorRegistration interceptorRegistration2 = registry.addInterceptor(new WebInterceptor2());
        interceptorRegistration2.addPathPatterns("/**");

        InterceptorRegistration interceptorRegistration3 = registry.addInterceptor(new WebInterceptor3());
        interceptorRegistration3.addPathPatterns("/**");
    }
}
