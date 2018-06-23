package com.zmf.realty.service.houseType.impl;

import com.alibaba.fastjson.JSONObject;
import com.zmf.realty.dao.HouseTypeMapper;
import com.zmf.realty.model.HouseType;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.houseType.HouseTypeService;
import com.zmf.realty.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-18 01:15
 */
@Service
@Transactional
public class HouseTypeServiceImpl implements HouseTypeService {
    @Autowired
    private HouseTypeMapper houseTypeDao;
    @Autowired
    private EncryptionService encryptionService;

    @Override
    public void insertHouseType(HouseType houseType) {
        houseTypeDao.insert(houseType);
    }

    @Override
    public void deleteHouseTypeById(String houseTypeId) {
        houseTypeDao.deleteByPrimaryKey(houseTypeId);
    }

    @Override
    public HouseType selectHouseTypeById(String houseTypeId) {
        return houseTypeDao.selectByPrimaryKey(houseTypeId);
    }

    @Override
    public List<HouseType> getAllHouseTypesByProjectId(String projectId) {
        return houseTypeDao.getAllHouseTypesByProjectId(projectId);
    }

    @Override
    public void updateHouseType(HouseType houseType) {
        houseTypeDao.updateByPrimaryKeySelective(houseType);
    }

    @Override
    public HouseType buildHouseType(String projectId, String price, String name, String size,
                                    String discount, String orientation, String decorationInfo,
                                    String telephone, String recommendReason, String tags) {
        return buildHouseType(projectId, price, name, size, discount, orientation,
                decorationInfo, telephone, recommendReason, IdUtil.generateId(), tags);
    }

    @Override
    public HouseType buildHouseType(String projectId, String price, String name, String size, String discount,
                                    String orientation, String decorationInfo, String telephone,
                                    String recommendReason, String typeId, String tags) {
        HouseType houseType = new HouseType();
        houseType.setProjectId(projectId);
        houseType.setPrice(price);
        houseType.setName(name);
        houseType.setSize(size);
        houseType.setDiscount(discount);
        houseType.setOrientation(orientation);
        houseType.setDecoration(decorationInfo);
        houseType.setTelephone(telephone);
        houseType.setReason(recommendReason);
        houseType.setTypeId(typeId);
        if (tags != null && tags.equals("\"\"")) {
            tags = " ";
        }
        houseType.setTags(tags);
        return houseType;
    }

    @Override
    public HouseType buildHouseType(String requestBody) {
        return buildHouseType(IdUtil.generateId(), requestBody);
    }

    @Override
    public HouseType buildHouseType(String houseTypeId, String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        return buildHouseType(encryptionService.decrypt(jsonObject.getString("project_id")),
                jsonObject.getString("price"), jsonObject.getString("name"),
                jsonObject.getString("size"), jsonObject.getString("discount"),
                jsonObject.getString("orientation"), jsonObject.getString("decoration_info"),
                jsonObject.getString("telephone"), jsonObject.getString("reason"),
                houseTypeId, jsonObject.getString("tags"));
    }
}
