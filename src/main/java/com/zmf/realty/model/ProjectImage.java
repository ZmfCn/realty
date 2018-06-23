package com.zmf.realty.model;

public class ProjectImage {
    /**
     * This field corresponds to the database column project_image.image_id
     *
     */
    private String imageId;

    /**
     * This field corresponds to the database column project_image.filepath
     *
     */
    private String filepath;

    /**
     * This field corresponds to the database column project_image.project_id
     *
     */
    private String projectId;

    /**
     * This method returns the value of the database column project_image.image_id
     *
     * @return the value of project_image.image_id
     *
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * This method sets the value of the database column project_image.image_id
     *
     * @param imageId the value for project_image.image_id
     *
     */
    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    /**
     * This method returns the value of the database column project_image.filepath
     *
     * @return the value of project_image.filepath
     *
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * This method sets the value of the database column project_image.filepath
     *
     * @param filepath the value for project_image.filepath
     *
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    /**
     * This method returns the value of the database column project_image.project_id
     *
     * @return the value of project_image.project_id
     *
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method sets the value of the database column project_image.project_id
     *
     * @param projectId the value for project_image.project_id
     *
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }
}