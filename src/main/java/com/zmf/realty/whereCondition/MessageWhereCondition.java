package com.zmf.realty.whereCondition;

import java.sql.Timestamp;

/**
 * @author zmf
 * @description The where conditions for the message query.
 * @timestamp 2018-07-14 15:58
 */
public class MessageWhereCondition {
    private boolean isRead;
    private String phone;
    private String call;
    private String content;
    private Timestamp after;

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getAfter() {
        return after;
    }

    public void setAfter(Timestamp after) {
        this.after = after;
    }
}
