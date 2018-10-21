package com.hjs.jwt.config;

import com.hjs.jwt.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by jianshuang_huang on 2018/10/19.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/login");

    }

}
