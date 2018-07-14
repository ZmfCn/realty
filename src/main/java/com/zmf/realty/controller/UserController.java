package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zmf.realty.annotation.ManagerRequired;
import com.zmf.realty.model.Manager;
import com.zmf.realty.service.jwt.JwtService;
import com.zmf.realty.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:25
 */
@RestController
@RequestMapping(value = "/api/", produces = "application/json;charset=utf-8")
public class UserController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "/login")
    public String login(@RequestBody String requestBody, HttpServletResponse response) {
        Manager manager = managerService.buildManager(requestBody);
        if (managerService.isValid(manager)) {
            String token = jwtService.createJwt(manager);
            Map<String, String> resp = new HashMap<>();
            resp.put("token", token);
            return JSON.toJSONString(resp);
        } else {
            response.setStatus(400);
            Map<String, String> resp = new HashMap<>();
            resp.put("error", "incorrect");
            return JSON.toJSONString(resp);
        }
    }

    @ManagerRequired
    @PutMapping(value = "/password")
    public String updateRootPassword(@RequestBody String requestBody, HttpServletResponse response) {
        JSONObject jsonObject = JSON.parseObject(requestBody);
        String oldPassword = jsonObject.getString("old_password");
        String newPassword = jsonObject.getString("new_password");
        Manager manager = new Manager();
        manager.setManagerName("root");
        manager.setManagerPassword(oldPassword);
        Map<String, String> res = new HashMap<>();
        if (!StringUtils.isEmpty(newPassword) && managerService.isValid(manager)) {
            manager.setManagerPassword(newPassword);
            managerService.updateByName(manager);
            res.put("success", "true");
        } else {
            response.setStatus(400);
            res.put("error", "invalid");
        }
        return JSON.toJSONString(res);
    }
}
