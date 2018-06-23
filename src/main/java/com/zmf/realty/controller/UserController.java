package com.zmf.realty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:25
 */
@RestController
@RequestMapping(value = "/api/user", produces = "application/json;charset=utf-8")
public class UserController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
