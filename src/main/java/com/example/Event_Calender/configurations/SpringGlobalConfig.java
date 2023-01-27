package com.example.Event_Calender.configurations;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SpringGlobalConfig implements WebMvcConfigurer {

    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*");
    }
}
