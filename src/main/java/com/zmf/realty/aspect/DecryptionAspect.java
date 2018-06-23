package com.zmf.realty.aspect;

import com.zmf.realty.service.encryption.EncryptionService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zmf
 * @description decrypt id from request
 * @timestamp 2018-06-15 11:39
 */
@Component
@Aspect
public class DecryptionAspect {
    @Autowired
    EncryptionService service;

    @Pointcut("@annotation(com.zmf.realty.annotation.IdDecryption)")
    public void route() {
    }

    @Around("route()")
    public Object decryptId(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String encryptedId = (String) args[0];
        String originId = service.decrypt(encryptedId);
        args[0] = originId;
        return joinPoint.proceed(args);
    }
}
