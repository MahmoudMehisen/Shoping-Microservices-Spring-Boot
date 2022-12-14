package com.mehisen.product.config;

import com.mehisen.product.filters.RequestResponseLoggers;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfig {

    @Bean
    FilterRegistrationBean<RequestResponseLoggers> createLogger(RequestResponseLoggers requestResponseLoggers){
        FilterRegistrationBean<RequestResponseLoggers> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(requestResponseLoggers);

        registrationBean.addUrlPatterns("/v1/addProduct","/v1/product/*");

        return registrationBean;
    }
}
