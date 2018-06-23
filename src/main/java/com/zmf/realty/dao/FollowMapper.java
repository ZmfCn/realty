package com.zmf.realty.dao;

import com.zmf.realty.model.Follow;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FollowMapper {
    /**
     * This method corresponds to the database table follow
     *
     */
    int deleteByPrimaryKey(String followId);

    /**
     * This method corresponds to the database table follow
     *
     */
    int insert(Follow record);

    /**
     * get follow amount by project id
     * @param projectId project id
     * @return amount
     */
    int getFollowAmountByProjectId(String projectId);

    /**
     * This method corresponds to the database table follow
     *
     */
    int insertSelective(Follow record);

    /**
     * This method corresponds to the database table follow
     *
     */
    Follow selectByPrimaryKey(String followId);

    /**
     * This method corresponds to the database table follow
     *
     */
    int updateByPrimaryKeySelective(Follow record);

    /**
     * This method corresponds to the database table follow
     *
     */
    int updateByPrimaryKey(Follow record);
}