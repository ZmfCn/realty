package com.zmf.realty.service.dto;

import com.zmf.realty.apiDto.HouseTypeDto;
import com.zmf.realty.apiDto.ImageDto;
import com.zmf.realty.apiDto.ProjectDto;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-17 16:14
 */
public interface DtoService {
    /**
     * build all project dto for "GET /api/projects"
     *
     * @return the list
     */
    List<ProjectDto> buildAllProjectDto();

    /**
     * build certain dto by id
     *
     * @param projectId the id of required project
     * @return the dto
     */
    ProjectDto buildCertainProjectDto(String projectId);

    /**
     * build house type dto by id
     *
     * @param houseTypeId house type id
     * @return the dto
     */
    HouseTypeDto buildHouseTypeDto(String houseTypeId);

    /**
     * build image dto by project id
     *
     * @param projectId project id
     * @return image dto
     */
    ImageDto buildImageDtoByProjectImageId(String projectId);

    /**
     * build image dto by house type id
     *
     * @param houseTypeId house type id
     * @return image dto
     */
    ImageDto buildImageDtoByHouseTypeImageId(String houseTypeId);

    /**
     * build carousels for home page
     *
     * @return list
     */
    List<ImageDto> buildCarousels();
}
