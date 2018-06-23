package com.zmf.realty.model;


public class Project {
    /**
     * This field corresponds to the database column project.project_id
     *
     */
    private String projectId;

    /**
     * This field corresponds to the database column project.deal_amount
     *
     */
    private Integer dealAmount;

    /**
     * This field corresponds to the database column project.name
     *
     */
    private String name;

    /**
     * This field corresponds to the database column project.size
     *
     */
    private String size;

    /**
     * This field corresponds to the database column project.price
     *
     */
    private String price;

    /**
     * This field corresponds to the database column project.address
     *
     */
    private String address;

    /**
     * This field corresponds to the database column project.location
     *
     */
    private String location;

    /**
     * This field corresponds to the database column project.tags
     *
     */
    private String tags;

    /**
     * This field corresponds to the database column project.created_at
     *
     */
    private java.sql.Timestamp createdAt;

    /**
     * This field corresponds to the database column project.telephone
     *
     */
    private String telephone;

    /**
     * This field corresponds to the database column project.is_show
     *
     */
    private boolean isShow;

    /**
     * This method returns the value of the database column project.project_id
     *
     * @return the value of project.project_id
     *
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method sets the value of the database column project.project_id
     *
     * @param projectId the value for project.project_id
     *
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * This method returns the value of the database column project.deal_amount
     *
     * @return the value of project.deal_amount
     *
     */
    public Integer getDealAmount() {
        return dealAmount;
    }

    /**
     * This method sets the value of the database column project.deal_amount
     *
     * @param dealAmount the value for project.deal_amount
     *
     */
    public void setDealAmount(Integer dealAmount) {
        this.dealAmount = dealAmount;
    }

    /**
     * This method returns the value of the database column project.name
     *
     * @return the value of project.name
     *
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column project.name
     *
     * @param name the value for project.name
     *
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column project.size
     *
     * @return the value of project.size
     *
     */
    public String getSize() {
        return size;
    }

    /**
     * This method sets the value of the database column project.size
     *
     * @param size the value for project.size
     *
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method returns the value of the database column project.price
     *
     * @return the value of project.price
     *
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method sets the value of the database column project.price
     *
     * @param price the value for project.price
     *
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * This method returns the value of the database column project.address
     *
     * @return the value of project.address
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method sets the value of the database column project.address
     *
     * @param address the value for project.address
     *
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method returns the value of the database column project.location
     *
     * @return the value of project.location
     *
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method sets the value of the database column project.location
     *
     * @param location the value for project.location
     *
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method returns the value of the database column project.tags
     *
     * @return the value of project.tags
     *
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method sets the value of the database column project.tags
     *
     * @param tags the value for project.tags
     *
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * This method returns the value of the database column project.created_at
     *
     * @return the value of project.created_at
     *
     */
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * This method sets the value of the database column project.created_at
     *
     * @param createdAt the value for project.created_at
     *
     */
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method returns the value of the database column project.telephone
     *
     * @return the value of project.telephone
     *
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method sets the value of the database column project.telephone
     *
     * @param telephone the value for project.telephone
     *
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method returns the value of the database column project.is_show
     *
     * @return the value of project.is_show
     *
     */
    public boolean getIsShow() {
        return isShow;
    }

    /**
     * This method sets the value of the database column project.is_show
     *
     * @param isShow the value for project.is_show
     *
     */
    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }
}