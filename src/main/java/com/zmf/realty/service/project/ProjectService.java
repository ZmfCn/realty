package com.zmf.realty.service.project;

import com.zmf.realty.model.ProjectWithBLOBs;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-13 20:10
 */
public interface ProjectService {
    /**
     * insert a new project
     *
     * @param project that contains all values
     */
    void insertProject(ProjectWithBLOBs project);

    /**
     * delete project by its id
     *
     * @param projectId project id
     */
    void deleteProjectById(String projectId);

    /**
     * get all projects
     *
     * @return all projects
     */
    List<ProjectWithBLOBs> getAllProjects();

    /**
     * get projects that match the keyword
     *
     * @param keyword the keyword to match
     * @return projects
     */
    List<ProjectWithBLOBs> getProjectsByKeyword(String keyword);


    /**
     * set the is_show field of project
     *
     * @param projectId project id
     * @param isShow    is_show
     */
    void setProjectShow(String projectId, boolean isShow);

    /**
     * update project by id
     *
     * @param newProject new project
     */
    void updateProject(ProjectWithBLOBs newProject);

    /**
     * get project by id
     *
     * @param projectId project id
     * @return project
     */
    ProjectWithBLOBs selectProjectById(String projectId);

    /**
     * build project according to the values
     *
     * @param recommendReason recommend reason
     * @param detail          detail
     * @param deal            deal amount
     * @param name            name
     * @param size            size
     * @param address         address
     * @param location        location
     * @param price           price
     * @param telephone       telephone number
     * @param tags            tags
     * @return project
     */
    ProjectWithBLOBs buildProject(String recommendReason, String detail,
                                  Integer deal, String name, String size, String price,
                                  String address, String location, String telephone, String tags);

    /**
     * build project according to the values
     *
     * @param projectId       project id
     * @param recommendReason recommend reason
     * @param detail          detail
     * @param deal            deal amount
     * @param name            name
     * @param size            size
     * @param address         address
     * @param location        location
     * @param price           price
     * @param telephone       telephone number
     * @param tags            tags
     * @return project
     */
    ProjectWithBLOBs buildProject(String projectId, String recommendReason, String detail,
                                  Integer deal, String name, String size, String price,
                                  String address, String location, String telephone, String tags);

    /**
     * build project according to the request body
     *
     * @param projectId   project id
     * @param requestBody the request body
     * @return project
     */
    ProjectWithBLOBs buildProject(String projectId, String requestBody);

    /**
     * build project according to the request body
     *
     * @param requestBody the request body
     * @return project
     */
    ProjectWithBLOBs buildProject(String requestBody);
}
