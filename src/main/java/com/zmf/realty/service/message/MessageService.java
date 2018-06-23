package com.zmf.realty.service.message;

import com.zmf.realty.model.Message;

import java.util.List;

/**
 * @author zmf
 * @description service for message
 * @timestamp 2018-06-14 16:33
 */
public interface MessageService {
    /**
     * add a new message
     *
     * @param message the message that contains all values needed
     */
    void addMessage(Message message);

    /**
     * delete a message by messageId
     *
     * @param messageId message id
     */
    void deleteMessage(String messageId);

    /**
     * get all messages that aren't read
     */
    List<Message> getAllUnreadMessages();

    /**
     * get all messages that are read
     */
    List<Message> getAllReadMessages();

    /**
     * set the status of the message read by message id
     *
     * @param messageId message id
     */
    void setMessageRead(String messageId);

    /**
     * build house type by values
     *
     * @param openid      user openid
     * @param content     content
     * @param isReaded    is the message readed
     * @param houseTypeId house type id
     * @return the instance
     */
    Message buildMessage(String openid, String content, Boolean isReaded, String houseTypeId);
}
