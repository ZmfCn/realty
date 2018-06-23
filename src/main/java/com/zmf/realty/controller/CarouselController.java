package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.annotation.IdDecryption;
import com.zmf.realty.service.dto.DtoService;
import com.zmf.realty.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:34
 */
@RestController
@RequestMapping(value = "/api/carousels", produces = "application/json;charset=utf-8")
public class CarouselController {
    @Autowired
    private DtoService dtoService;
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public String getCarousels() {
        return JSON.toJSONString(dtoService.buildCarousels());
    }

    @IdDecryption
    @PostMapping(value = "/{projectId}")
    public String addCarousel(@PathVariable() String projectId) {
        Map<String, String> map = new HashMap<>();
        projectService.setProjectShow(projectId, true);
        map.put("success", "true");
        return JSON.toJSONString(map);
    }

    @IdDecryption
    @DeleteMapping(value = "/{projectId}")
    public String deleteCarousel(@PathVariable() String projectId) {
        Map<String, String> map = new HashMap<>();
        projectService.setProjectShow(projectId, false);
        map.put("success", "true");
        return JSON.toJSONString(map);
    }
}
