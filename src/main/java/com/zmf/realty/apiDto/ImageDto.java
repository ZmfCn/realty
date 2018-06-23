package com.zmf.realty.apiDto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-22 19:50
 */
public class ImageDto {
    private String url;

    @JSONField(name = "image_id")
    private String imageId;

    @JSONField(name = "project_id")
    private String projectId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
