package com.zmf.realty.model;


public class Message {
    /**
     * This field corresponds to the database column message.message_id
     *
     */
    private String messageId;

    /**
     * This field corresponds to the database column message.openid
     *
     */
    private String openid;

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
     * This field corresponds to the database column message.house_type_id
     *
     */
    private String houseTypeId;

    /**
     * This field corresponds to the database column message.datetime
     *
     */
    private java.sql.Timestamp datetime;

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
     * This method returns the value of the database column message.openid
     *
     * @return the value of message.openid
     *
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method sets the value of the database column message.openid
     *
     * @param openid the value for message.openid
     *
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
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
     * This method returns the value of the database column message.house_type_id
     *
     * @return the value of message.house_type_id
     *
     */
    public String getHouseTypeId() {
        return houseTypeId;
    }

    /**
     * This method sets the value of the database column message.house_type_id
     *
     * @param houseTypeId the value for message.house_type_id
     *
     */
    public void setHouseTypeId(String houseTypeId) {
        this.houseTypeId = houseTypeId == null ? null : houseTypeId.trim();
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
}