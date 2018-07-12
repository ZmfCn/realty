package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-12 12:14
 */
@RestController
@RequestMapping(value = "/api/errors", produces = "application/json;charset=utf-8")
public class ErrorController {
    @RequestMapping(value = "/invalid", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public String invalidError(HttpServletResponse response) {
        response.setStatus(401);
        Map<String, String> resp = new HashMap<>();
        resp.put("error", "token invalid");
        return JSON.toJSONString(resp);
    }
}
