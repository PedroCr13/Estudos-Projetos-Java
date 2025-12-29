package com.hachathon.backend_simulador_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hachathon.backend_simulador_api.monitoring.TempoInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
	@Autowired
    private TempoInterceptor tempoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tempoInterceptor);
    }
}
