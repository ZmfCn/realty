package com.zmf.realty.dao;

import com.zmf.realty.model.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * This method corresponds to the database table user
     *
     */
    int deleteByPrimaryKey(String userOpenid);

    /**
     * This method corresponds to the database table user
     *
     */
    int insert(User record);

    /**
     * This method corresponds to the database table user
     *
     */
    int insertSelective(User record);

    /**
     * This method corresponds to the database table user
     *
     */
    User selectByPrimaryKey(String userOpenid);

    /**
     * This method corresponds to the database table user
     *
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method corresponds to the database table user
     *
     */
    int updateByPrimaryKey(User record);
}