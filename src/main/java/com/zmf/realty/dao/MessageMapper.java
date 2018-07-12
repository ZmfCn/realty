package com.zmf.realty.dao;

import com.zmf.realty.model.Message;

import java.util.List;

public interface MessageMapper {
    /**
     * This method corresponds to the database table message
     */
    int deleteByPrimaryKey(String messageId);

    /**
     * This method corresponds to the database table message
     */
    int insertSelective(Message record);

    /**
     * This method corresponds to the database table message
     */
    Message selectByPrimaryKey(String messageId);


    /**
     * This method corresponds to the database table message
     */
    int updateByPrimaryKeySelective(Message record);


    /**
     * get all
     *
     * @return the list
     */
    List<Message> getAllMessages();


    /**
     * get the ids of the project
     *
     * @param projectId project id
     * @return the list
     */
    List<String> getAllMessageIdsByProjectId(String projectId);
}