package com.ibmz.watsonxLeave.intercepter;

import com.ibmz.watsonxLeave.annotation.AuthVerify;
import com.ibmz.watsonxLeave.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;
@Log4j2
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
@Autowired
TokenService tokenService;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String token = httpServletRequest.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            method.getAnnotation(AuthVerify.class);
            return tokenService.verify(token);

        }
        log.info("no handler intercepted");
        return true;
    }
}
