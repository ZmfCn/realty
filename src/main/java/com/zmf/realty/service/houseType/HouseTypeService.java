package com.zmf.realty.service.houseType;

import com.zmf.realty.model.HouseType;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-14 19:22
 */
public interface HouseTypeService {
    /**
     * insert house type into database
     *
     * @param houseType that contains all values
     */
    void insertHouseType(HouseType houseType);

    /**
     * delete house type by id
     *
     * @param houseTypeId house type id
     */
    void deleteHouseTypeById(String houseTypeId);


    /**
     * select by id
     *
     * @param houseTypeId house type id
     * @return result
     */
    HouseType selectHouseTypeById(String houseTypeId);

    /**
     * get all house types by project id
     *
     * @param projectId project id
     * @return house type
     */
    List<HouseType> getAllHouseTypesByProjectId(String projectId);

    /**
     * uodate house type
     *
     * @param houseType house type
     */
    void updateHouseType(HouseType houseType);

    /**
     * build a new instance of HouseType
     *
     * @param projectId       project id
     * @param price           price
     * @param name            name
     * @param size            size
     * @param discount        discount
     * @param orientation     orientation
     * @param decorationInfo  decoration information
     * @param telephone       telephone number
     * @param recommendReason reason for recommendation
     * @param tags            tags of house type
     * @return tha instance
     */
    HouseType buildHouseType(String projectId, String price, String name, String size,
                             String discount, String orientation, String decorationInfo, String telephone,
                             String recommendReason, String tags);

    /**
     * build a new instance of HouseType
     *
     * @param projectId       project id
     * @param price           price
     * @param name            name
     * @param size            size
     * @param discount        discount
     * @param orientation     orientation
     * @param decorationInfo  decoration information
     * @param telephone       telephone number
     * @param recommendReason reason for recommendation
     * @param typeId          type id
     * @param tags            tags of house type
     * @return tha instance
     */
    HouseType buildHouseType(String projectId, String price, String name, String size,
                             String discount, String orientation, String decorationInfo, String telephone,
                             String recommendReason, String typeId, String tags);


    /**
     * build an instance of HouseType
     *
     * @param requestBody request body
     * @return the instance
     */
    HouseType buildHouseType(String requestBody);

    /**
     * build an instance of HouseType
     *
     * @param houseTypeId house type id
     * @param requestBody request body
     * @return the instance
     */
    HouseType buildHouseType(String houseTypeId, String requestBody);
}
