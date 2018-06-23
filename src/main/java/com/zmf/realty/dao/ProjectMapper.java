package com.zmf.realty.dao;

import com.zmf.realty.model.ProjectWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {

    /**
     * This method corresponds to the database table project
     */
    int deleteByPrimaryKey(String projectId);

    /**
     * This method corresponds to the database table project
     */
    int insert(ProjectWithBLOBs record);

    /**
     * This method corresponds to the database table project
     */
    int insertSelective(ProjectWithBLOBs record);


    /**
     * This method corresponds to the database table project
     */
    ProjectWithBLOBs selectByPrimaryKey(String projectId);

    /**
     * This method corresponds to the database table project
     */
    int updateByPrimaryKeySelective(ProjectWithBLOBs record);

    /**
     * This method corresponds to the database table project
     */
    int updateByPrimaryKeyWithBLOBs(ProjectWithBLOBs record);

    /**
     * set the is_show field of project
     *
     * @param projectId project id
     * @param isShow    is_show
     */
    void setProjectShow(@Param("project_id") String projectId, @Param("is_show") boolean isShow);


    /**
     * get projects to show
     *
     * @return project list
     */
    List<ProjectWithBLOBs> getProjectsToShow();


    List<ProjectWithBLOBs> getAllProjects();

    /**
     * get projects that match the keyword
     *
     * @param keyword the keyword to match
     * @return projects
     */
    List<ProjectWithBLOBs> getProjectsByKeyword(String keyword);
}