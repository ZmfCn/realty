package com.zmf.realty.configuration;

import com.zmf.realty.interceptor.PublicAccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-19 23:49
 */
//@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private PublicAccessInterceptor publicAccessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(publicAccessInterceptor);
    }
}
