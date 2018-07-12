package com.zmf.realty.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-19 20:23
 */
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("x-auth-token", "content-type", "x_request_with")
                        .allowCredentials(true)
                        .exposedHeaders(HttpHeaders.SET_COOKIE);
            }
        };
    }
}
