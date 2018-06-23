package com.zmf.realty.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zmf
 * @description to implement CORS(Cross-Origin Resource Sharing)
 * @timestamp 2018-06-14 00:16
 */
@Component
public class CorsAspect {
    @Pointcut("execution(public * com.zmf.realty.controller..*.*(..))")
    public void setCorsResponseHeader() {
    }

    @AfterReturning(pointcut = "setCorsResponseHeader()")
    public void doAfterReturning() throws Throwable {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        if (response != null) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "x-auth-token, content-type, x_request_with");
        }
    }
}
