package com.zmf.realty.dao;

import com.zmf.realty.model.ProjectImage;

import java.util.List;

public interface ProjectImageMapper {

    /**
     * This method corresponds to the database table project_image
     */
    int deleteByPrimaryKey(String imageId);

    /**
     * This method corresponds to the database table project_image
     */
    int insert(ProjectImage record);

    /**
     * This method corresponds to the database table project_image
     */
    int insertSelective(ProjectImage record);


    /**
     * This method corresponds to the database table project_image
     */
    ProjectImage selectByPrimaryKey(String imageId);


    /**
     * get images of project by project id
     *
     * @param projectId the project id
     * @return result
     */
    List<ProjectImage> getImagesByProjectId(String projectId);

    /**
     * This method corresponds to the database table project_image
     */
    int updateByPrimaryKeySelective(ProjectImage record);

    /**
     * This method corresponds to the database table project_image
     */
    int updateByPrimaryKeyWithBLOBs(ProjectImage record);

    /**
     * This method corresponds to the database table project_image
     */
    int updateByPrimaryKey(ProjectImage record);

    /**
     * get the first image by project id
     *
     * @param projectId project id
     * @return image
     */
    ProjectImage getFirstImageByProjectId(String projectId);
}