package com.zmf.realty.apiDto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-11 20:41
 */
public class MessageDto {
    /*
    "message_id": "uuid",
  "project_id": "uuid",
  "content": "asd",
  "phone": "15087186168",
  "call": "Mr. Wang",
  "time": "timestamp",
  "is_read": false
     */
    @JSONField(name = "message_id")
    private String messageId;
    @JSONField(name = "project_id")
    private String projectId;
    private String content;
    private String phone;
    private String call;
    private String time;
    @JSONField(name = "project_name")
    private String projectName;
    private boolean isRead;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
