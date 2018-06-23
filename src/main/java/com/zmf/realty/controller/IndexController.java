package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.annotation.IdDecryption;
import com.zmf.realty.model.ProjectWithBLOBs;
import com.zmf.realty.service.file.impl.FileServiceImpl;
import com.zmf.realty.service.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-12 22:34
 */
@RestController
@RequestMapping(value = "/", produces = "application/json;charset=utf-8")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectService service;

    @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public String user() {
        return "/user";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "{name: 1}";
    }

    @RequestMapping(value = "/insert")
    public String insert() {
        ProjectWithBLOBs project = new ProjectWithBLOBs();
        project.setSize("约80m2");
        project.setDetail("detail");
        project.setAddress("address");
        project.setPrice("price");
        project.setName("name");
        project.setDealAmount(1);
        project.setReason("reason");
        return JSON.toJSONString(project);
    }

    @RequestMapping(value = "/select")
    public String select() {
        ProjectWithBLOBs project = service.selectProjectById("afasf");
        return JSON.toJSONString(project);
    }

    @RequestMapping()
    public String openid(@RequestParam("openid") String openid) {
        return openid;
    }

    @IdDecryption()
    @RequestMapping("/{id}")
    public String testId(@PathVariable() String id) {
        logger.info(id);
        return id;
    }
}
