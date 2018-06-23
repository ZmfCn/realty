package com.zmf.realty.dao;

import com.zmf.realty.model.Message;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {

    /**
     * This method corresponds to the database table message
     *
     */
    int deleteByPrimaryKey(String messageId);

    /**
     * This method corresponds to the database table message
     *
     */
    int insert(Message record);

    /**
     * This method corresponds to the database table message
     *
     */
    int insertSelective(Message record);


    /**
     * This method corresponds to the database table message
     *
     */
    Message selectByPrimaryKey(String messageId);

    /**
     * This method corresponds to the database table message
     *
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * This method corresponds to the database table message
     *
     */
    int updateByPrimaryKey(Message record);
}