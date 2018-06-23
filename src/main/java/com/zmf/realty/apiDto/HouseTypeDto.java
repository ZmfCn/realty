package com.zmf.realty.apiDto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-17 16:20
 */
public class HouseTypeDto {
    @JSONField(name = "house_type_id")
    private String typeId;
    @JSONField(name = "project_id")
    private String projectId;
    private List<ImageDto> carousels;
    private String name;
    private String size;
    private String price;
    private List<String> tags;
    private String reason;
    private String telephone;
    private String discount;
    private String orientation;
    private String decoration;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<ImageDto> getCarousels() {
        return carousels;
    }

    public void setCarousels(List<ImageDto> carousels) {
        this.carousels = carousels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }
}
