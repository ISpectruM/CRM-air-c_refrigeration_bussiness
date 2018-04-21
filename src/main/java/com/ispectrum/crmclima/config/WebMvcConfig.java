package com.ispectrum.crmclima.config;


import com.ispectrum.crmclima.interceptors.OrderInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final OrderInfoInterceptor orderInfoInterceptor;

    @Autowired
    public WebMvcConfig(OrderInfoInterceptor orderInfoInterceptor) {
        this.orderInfoInterceptor = orderInfoInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.orderInfoInterceptor);
    }
}
