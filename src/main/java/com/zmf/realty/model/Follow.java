package com.zmf.realty.model;


public class Follow {
    /**
     * This field corresponds to the database column follow.follow_id
     *
     */
    private String followId;

    /**
     * This field corresponds to the database column follow.user_openid
     *
     */
    private String userOpenid;

    /**
     * This field corresponds to the database column follow.project_id
     *
     */
    private String projectId;

    /**
     * This field corresponds to the database column follow.datetime
     *
     */
    private java.sql.Timestamp datetime;

    /**
     * This method returns the value of the database column follow.follow_id
     *
     * @return the value of follow.follow_id
     *
     */
    public String getFollowId() {
        return followId;
    }

    /**
     * This method sets the value of the database column follow.follow_id
     *
     * @param followId the value for follow.follow_id
     *
     */
    public void setFollowId(String followId) {
        this.followId = followId == null ? null : followId.trim();
    }

    /**
     * This method returns the value of the database column follow.user_openid
     *
     * @return the value of follow.user_openid
     *
     */
    public String getUserOpenid() {
        return userOpenid;
    }

    /**
     * This method sets the value of the database column follow.user_openid
     *
     * @param userOpenid the value for follow.user_openid
     *
     */
    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    /**
     * This method returns the value of the database column follow.project_id
     *
     * @return the value of follow.project_id
     *
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method sets the value of the database column follow.project_id
     *
     * @param projectId the value for follow.project_id
     *
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * This method returns the value of the database column follow.datetime
     *
     * @return the value of follow.datetime
     *
     */
    public java.sql.Timestamp getDatetime() {
        return datetime;
    }

    /**
     * This method sets the value of the database column follow.datetime
     *
     * @param datetime the value for follow.datetime
     *
     */
    public void setDatetime(java.sql.Timestamp datetime) {
        this.datetime = datetime;
    }
}