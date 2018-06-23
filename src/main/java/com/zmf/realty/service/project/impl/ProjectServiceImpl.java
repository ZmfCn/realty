package com.zmf.realty.service.project.impl;

import com.alibaba.fastjson.JSONObject;
import com.zmf.realty.dao.ProjectMapper;
import com.zmf.realty.model.ProjectWithBLOBs;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.project.ProjectService;
import com.zmf.realty.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-13 20:12
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectDao;

    @Override
    public void insertProject(ProjectWithBLOBs project) {
        projectDao.insert(project);
    }

    @Override
    public void deleteProjectById(String projectId) {
        projectDao.deleteByPrimaryKey(projectId);
    }

    @Override
    public List<ProjectWithBLOBs> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public List<ProjectWithBLOBs> getProjectsByKeyword(String keyword) {
        return projectDao.getProjectsByKeyword(keyword);
    }

    @Override
    public void setProjectShow(String projectId, boolean isShow) {
        projectDao.setProjectShow(projectId, isShow);
    }

    @Override
    public void updateProject(ProjectWithBLOBs newProject) {
        projectDao.updateByPrimaryKeySelective(newProject);
    }


    @Override
    public ProjectWithBLOBs selectProjectById(String projectId) {
        return projectDao.selectByPrimaryKey(projectId);
    }

    @Override
    public ProjectWithBLOBs buildProject(String recommendReason, String detail, Integer deal, String name, String size, String price, String address, String location, String telephone, String tags) {
        return buildProject(IdUtil.generateId(), recommendReason, detail, deal, name, size, price, address, location, telephone, tags);
    }

    @Override
    public ProjectWithBLOBs buildProject(String projectId, String recommendReason, String detail,
                                         Integer deal, String name, String size, String price,
                                         String address, String location, String telephone, String tags) {
        ProjectWithBLOBs project = new ProjectWithBLOBs();
        project.setProjectId(projectId);
        project.setReason(recommendReason);
        project.setDetail(detail);
        project.setDealAmount(deal);
        project.setName(name);
        project.setSize(size);
        project.setPrice(price);
        project.setAddress(address);
        project.setLocation(location);
        project.setTelephone(telephone);
        project.setIsShow(false);
        if (tags != null && tags.equals("\"\"")) {
            tags = " ";
        }
        project.setTags(tags);
        return project;
    }

    @Override
    public ProjectWithBLOBs buildProject(String projectId, String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        return buildProject(projectId, jsonObject.getString("reason"),
                jsonObject.getString("detail"), jsonObject.getInteger("deal_amount"),
                jsonObject.getString("name"), jsonObject.getString("size"),
                jsonObject.getString("price"), jsonObject.getString("address"),
                jsonObject.getString("location"), jsonObject.getString("telephone"),
                jsonObject.getString("tags"));
    }

    @Override
    public ProjectWithBLOBs buildProject(String requestBody) {
        return buildProject(IdUtil.generateId(), requestBody);
    }
}
