package com.yajun.demo.interceptors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 【拦截器入口】
 *
 * @author
 */
@Configuration
@ComponentScan("com.yajun.demo.interceptors")
public abstract class BaseInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpInterceptor());
        //registry.addInterceptor(corsInterceptor()).addPathPatterns("/web/**");
        registry.addInterceptor(commonInterceptor());
//        registry.addInterceptor(identifyInterceptor()).addPathPatterns("/getPayInfo", "/checkOrderPay", "/createIosOrder", "/iosNotifyPay");
    }

    @Bean
    public HandlerInterceptor httpInterceptor() {
        return new HttpInterceptor();
    }

    @Bean
    public HandlerInterceptor commonInterceptor() {
        return new CommonInterceptor();
    }

    @Bean
    public IdentifyInterceptor identifyInterceptor() {
        return new IdentifyInterceptor();
    }

    @Bean
    public CorsInterceptor corsInterceptor() {
        return new CorsInterceptor();
    }

}
