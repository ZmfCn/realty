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
     * get message by message id
     *
     * @param messageId the id
     * @return the message
     */
    Message getMessage(String messageId);

    /**
     * get all messages that aren't read
     *
     * @return the list
     */
    List<Message> getAllUnreadMessages();

    /**
     * get all messages that are read
     *
     * @return the list
     */
    List<Message> getAllReadMessages();


    /**
     * get all messages
     *
     * @return the list
     */
    List<Message> getAllMessages();

    /**
     * set the status of the message read by message id
     *
     * @param messageId message id
     */
    void setMessageRead(String messageId);

    /**
     * build house type by values
     *
     * @param messageId message id
     * @param projectId project id
     * @param content   content
     * @param phone     the phone
     * @param call      the call of the people who leaves the message
     * @param isRead    is the message read
     * @return the instance
     */
    Message buildMessage(String messageId, String projectId, String content, String phone, String call,
                         boolean isRead);

    /**
     * build message from request body
     *
     * @param requestBody the request from web
     * @return the instance
     */
    Message buildMessage(String requestBody);
}
