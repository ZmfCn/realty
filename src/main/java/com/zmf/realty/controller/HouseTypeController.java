package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.annotation.IdDecryption;
import com.zmf.realty.apiDto.HouseTypeDto;
import com.zmf.realty.model.HouseType;
import com.zmf.realty.service.dto.DtoService;
import com.zmf.realty.service.houseType.HouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:33
 */
@RestController
@RequestMapping(value = "/api/house_types", produces = "application/json;charset=utf-8")
public class HouseTypeController {
    @Autowired
    private HouseTypeService houseTypeService;
    @Autowired
    private DtoService dtoService;

    @PostMapping
    public String addHouseType(@RequestBody String requestBody) {
        HouseType houseType = houseTypeService.buildHouseType(requestBody);
        houseTypeService.insertHouseType(houseType);
        return JSON.toJSONString(houseTypeService.selectHouseTypeById(houseType.getTypeId()));
    }

    @IdDecryption
    @GetMapping("/{houseTypeId}")
    public String getCertainHouseType(@PathVariable() String houseTypeId) {
        return JSON.toJSONString(dtoService.buildHouseTypeDto(houseTypeId));
    }

    @IdDecryption
    @PutMapping("/{houseTypeId}")
    public String updateHouseType(@PathVariable() String houseTypeId, @RequestBody String requestBody) {
        HouseType houseType = houseTypeService.buildHouseType(houseTypeId, requestBody);
        houseTypeService.updateHouseType(houseType);
        return JSON.toJSONString(dtoService.buildHouseTypeDto(houseTypeId));
    }

    @IdDecryption
    @DeleteMapping("/{houseTypeId}")
    public String deleteHouseType(@PathVariable() String houseTypeId){
        HouseTypeDto dto = dtoService.buildHouseTypeDto(houseTypeId);
        houseTypeService.deleteHouseTypeById(houseTypeId);
        return JSON.toJSONString(dto);
    }
}
