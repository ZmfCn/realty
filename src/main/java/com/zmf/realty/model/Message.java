package com.zmf.realty.model;


public class Message {
    /**
     * This field corresponds to the database column message.message_id
     *
     */
    private String messageId;

    /**
     * This field corresponds to the database column message.content
     *
     */
    private String content;

    /**
     * This field corresponds to the database column message.is_readed
     *
     */
    private Boolean isReaded;

    /**
     * This field corresponds to the database column message.datetime
     *
     */
    private java.sql.Timestamp datetime;

    /**
     * This field corresponds to the database column message.project_id
     *
     */
    private String projectId;

    /**
     * This field corresponds to the database column message.phone
     *
     */
    private String phone;

    /**
     * This field corresponds to the database column message.call
     *
     */
    private String call;

    /**
     * This method returns the value of the database column message.message_id
     *
     * @return the value of message.message_id
     *
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * This method sets the value of the database column message.message_id
     *
     * @param messageId the value for message.message_id
     *
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    /**
     * This method returns the value of the database column message.content
     *
     * @return the value of message.content
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * This method sets the value of the database column message.content
     *
     * @param content the value for message.content
     *
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method returns the value of the database column message.is_readed
     *
     * @return the value of message.is_readed
     *
     */
    public Boolean getIsReaded() {
        return isReaded;
    }

    /**
     * This method sets the value of the database column message.is_readed
     *
     * @param isReaded the value for message.is_readed
     *
     */
    public void setIsReaded(Boolean isReaded) {
        this.isReaded = isReaded;
    }

    /**
     * This method returns the value of the database column message.datetime
     *
     * @return the value of message.datetime
     *
     */
    public java.sql.Timestamp getDatetime() {
        return datetime;
    }

    /**
     * This method sets the value of the database column message.datetime
     *
     * @param datetime the value for message.datetime
     *
     */
    public void setDatetime(java.sql.Timestamp datetime) {
        this.datetime = datetime;
    }

    /**
     * This method returns the value of the database column message.project_id
     *
     * @return the value of message.project_id
     *
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method sets the value of the database column message.project_id
     *
     * @param projectId the value for message.project_id
     *
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * This method returns the value of the database column message.phone
     *
     * @return the value of message.phone
     *
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method sets the value of the database column message.phone
     *
     * @param phone the value for message.phone
     *
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method returns the value of the database column message.call
     *
     * @return the value of message.call
     *
     */
    public String getCall() {
        return call;
    }

    /**
     * This method sets the value of the database column message.call
     *
     * @param call the value for message.call
     *
     */
    public void setCall(String call) {
        this.call = call == null ? null : call.trim();
    }
}