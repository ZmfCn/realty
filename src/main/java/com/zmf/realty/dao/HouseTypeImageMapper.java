package com.zmf.realty.dao;

import com.zmf.realty.model.HouseTypeImage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HouseTypeImageMapper {

    /**
     * This method corresponds to the database table house_type_image
     */
    int deleteByPrimaryKey(String imageId);

    /**
     * This method corresponds to the database table house_type_image
     */
    int insert(HouseTypeImage record);

    /**
     * This method corresponds to the database table house_type_image
     */
    int insertSelective(HouseTypeImage record);

    /**
     * This method corresponds to the database table house_type_image
     */
    HouseTypeImage selectByPrimaryKey(String imageId);


    /**
     * This method corresponds to the database table house_type_image
     */
    int updateByPrimaryKeySelective(HouseTypeImage record);

    /**
     * This method corresponds to the database table house_type_image
     */
    int updateByPrimaryKey(HouseTypeImage record);

    /**
     * get images of house type by house type id
     *
     * @param houseTypeId house type id
     * @return image list
     */
    List<HouseTypeImage> getImagesByHouseTypeId(String houseTypeId);
}