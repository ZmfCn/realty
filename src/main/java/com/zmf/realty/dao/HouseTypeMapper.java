package com.zmf.realty.dao;

import com.zmf.realty.model.HouseType;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseTypeMapper {

    /**
     * This method corresponds to the database table house_type
     *
     */
    int deleteByPrimaryKey(String typeId);

    /**
     * This method corresponds to the database table house_type
     *
     */
    int insert(HouseType record);

    /**
     * This method corresponds to the database table house_type
     *
     */
    int insertSelective(HouseType record);

    /**
     * This method corresponds to the database table house_type
     *
     */
    HouseType selectByPrimaryKey(String typeId);

    /**
     * get all house types by project id
     *
     * @param projectId project id
     * @return house type
     */
    List<HouseType> getAllHouseTypesByProjectId(String projectId);

    /**
     * This method corresponds to the database table house_type
     *
     */
    int updateByPrimaryKeySelective(HouseType record);

    /**
     * This method corresponds to the database table house_type
     *
     */
    int updateByPrimaryKeyWithBLOBs(HouseType record);
}