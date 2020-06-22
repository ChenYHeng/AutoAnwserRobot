package com.micromsg.demo.core.cors;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 允许访问的来源
        List<String> origins = new ArrayList<>();
        origins.add("http://localhost:8081");
        corsConfiguration.setAllowedOrigins(origins);

        // 允许发送cookies
        corsConfiguration.setAllowCredentials(true);

        // 允许的请求方式
        List<String> methods = new ArrayList<>();
        methods.add("POST");
        corsConfiguration.setAllowedMethods(methods);

        // 允许头信息
        List<String> headers = new ArrayList<>();
        headers.add("*");
        corsConfiguration.setAllowedHeaders(headers);

        // 添加映射路径
        UrlBasedCorsConfigurationSource configSouce = new UrlBasedCorsConfigurationSource();
        configSouce.registerCorsConfiguration("/**", corsConfiguration);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(configSouce));
        bean.setOrder(0);
        return bean;
    }
}
