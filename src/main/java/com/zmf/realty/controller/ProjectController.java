package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.annotation.IdDecryption;
import com.zmf.realty.model.ProjectWithBLOBs;
import com.zmf.realty.service.dto.DtoService;
import com.zmf.realty.service.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:33
 */
@RestController
@RequestMapping(value = "/api/projects", produces = "application/json;charset=utf-8")
public class ProjectController {
    @Autowired
    private DtoService dtoService;
    @Autowired
    private ProjectService projectService;

    private Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping
    public String getAllProjects() {
        return JSON.toJSONString(dtoService.buildAllProjectDto());
    }

    @PostMapping
    public String addProject(@RequestBody String requestBody) {
        logger.info(requestBody);
        ProjectWithBLOBs project = projectService.buildProject(requestBody);
        projectService.insertProject(project);
        return JSON.toJSONString(dtoService.buildCertainProjectDto(project.getProjectId()));
    }

    @IdDecryption
    @GetMapping(value = "/{projectId}")
    public String getCertainProject(@PathVariable() String projectId) {
        return JSON.toJSONString(dtoService.buildCertainProjectDto(projectId));
    }

    @IdDecryption
    @PutMapping(value = "/{projectId}")
    public String updateProject(@PathVariable() String projectId, @RequestBody String requestBody) {
        ProjectWithBLOBs project = projectService.buildProject(projectId, requestBody);
        projectService.updateProject(project);
        return JSON.toJSONString(dtoService.buildCertainProjectDto(project.getProjectId()));
    }

    @IdDecryption
    @DeleteMapping(value = "/{projectId}")
    public String deleteProject(@PathVariable() String projectId) {
        String returnValue = JSON.toJSONString(dtoService.buildCertainProjectDto(projectId));
        projectService.deleteProjectById(projectId);
        return returnValue;
    }
}
