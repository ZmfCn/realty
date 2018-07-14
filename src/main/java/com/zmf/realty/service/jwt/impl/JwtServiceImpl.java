package com.zmf.realty.service.jwt.impl;

import com.zmf.realty.model.Manager;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.jwt.JwtService;
import com.zmf.realty.service.manager.ManagerService;
import com.zmf.realty.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-11 19:41
 */
@Service
public class JwtServiceImpl implements JwtService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);
    @Value("${jwt.base64Secret}")
    private String sercet;

    @Value("${jwt.clientId}")
    private String clientId;

    @Value("${jwt.expiresSecond}")
    private long expiresSecond;
//    @Value("${jwt.base64Secret}")
//    private String sercet = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjYAAA=";
//
//    @Value("${jwt.clientId}")
//    private String clientId = "098f6bcd4621d373cade4e832627b4f6123";
//
//    @Value("${jwt.expiresSecond}")
//    private long expiresSecond = 864;

    @Autowired
    private ManagerService managerService;
    @Autowired
    private EncryptionService encryptionService;


    @Test
    public void testJwtExpire() {
        JwtServiceImpl jwtService = new JwtServiceImpl();
        Manager manager = new Manager();
        manager.setManagerPassword("1234");
        manager.setManagerName("root");
        String jwt = jwtService.createJwt(manager);
        System.out.println(jwt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        manager = jwtService.getManagerFromJwt(jwt);
        System.out.println(manager.getManagerName());
    }

    @Override
    public String createJwt(Manager manager) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", manager.getManagerName());
        claims.put("password", encryptionService.encrypt(manager.getManagerPassword()));
        logger.info("seconds: " + expiresSecond);
        try {
            return JwtUtil.createJWT(UUID.randomUUID().toString(), expiresSecond, claims, JwtUtil.generalKey(sercet));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Manager getManagerFromJwt(String jwt) {
        Manager manager = new Manager();
        try {
            Claims claims = JwtUtil.parseJWT(jwt, JwtUtil.generalKey(sercet));
            manager.setManagerName(claims.get("name", String.class));
            manager.setManagerPassword(encryptionService.decrypt(claims.get("password", String.class)));
            return manager;
        } catch (Exception e) {
            e.printStackTrace();
            return manager;
        }
    }

    @Override
    public boolean isValid(String jwt) {
        try {
            if (jwt == null) {
                return false;
            }
            Manager manager = getManagerFromJwt(jwt);
            return manager.getManagerName() != null && manager.getManagerPassword() != null && managerService.isValid(manager);
        } catch (Exception e) {
            return false;
        }
    }
}
