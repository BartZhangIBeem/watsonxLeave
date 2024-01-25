package com.ibmz.watsonxLeave.config;

import com.ibmz.watsonxLeave.intercepter.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AuthenticationInterceptor authenticationInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                //拦截
                .addPathPatterns("/query/*")
                //放行
                .excludePathPatterns("/token").excludePathPatterns("/v3/api-docs");
    }
}
