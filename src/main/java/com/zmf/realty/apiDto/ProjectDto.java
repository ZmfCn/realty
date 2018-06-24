package com.zmf.realty.apiDto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-17 15:53
 */
public class ProjectDto {
    @JSONField(name = "project_id")
    private String projectId;
    private List<ImageDto> carousels;
    private String name;
    private String size;
    private String price;
    private String address;
    private List<String> tags;
    @JSONField(name = "follow_amount")
    private Integer followAmount;
    @JSONField(name = "deal_amount")
    private Integer dealAmount;
    private String reason;
    private String detail;
    private String location;
    private String telephone;
    @JSONField(name = "house_type_ids")
    private List<String> houseTypeIds;
    @JSONField(name = "is_show")
    private boolean isShow;

    public List<String> getHouseTypeIds() {
        return houseTypeIds;
    }

    public void setHouseTypeIds(List<String> houseTypeIds) {
        this.houseTypeIds = houseTypeIds;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getFollowAmount() {
        return followAmount;
    }

    public void setFollowAmount(Integer followAmount) {
        this.followAmount = followAmount;
    }

    public Integer getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Integer dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
