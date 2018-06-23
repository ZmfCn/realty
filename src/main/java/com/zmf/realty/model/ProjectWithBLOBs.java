package com.zmf.realty.model;

public class ProjectWithBLOBs extends Project {
    /**
     * This field corresponds to the database column project.reason
     *
     */
    private String reason;

    /**
     * This field corresponds to the database column project.detail
     *
     */
    private String detail;

    /**
     * This method returns the value of the database column project.reason
     *
     * @return the value of project.reason
     *
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method sets the value of the database column project.reason
     *
     * @param reason the value for project.reason
     *
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * This method returns the value of the database column project.detail
     *
     * @return the value of project.detail
     *
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method sets the value of the database column project.detail
     *
     * @param detail the value for project.detail
     *
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}