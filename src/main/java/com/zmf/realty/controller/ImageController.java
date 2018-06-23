package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.annotation.IdDecryption;
import com.zmf.realty.apiDto.ImageDto;
import com.zmf.realty.model.HouseTypeImage;
import com.zmf.realty.model.ProjectImage;
import com.zmf.realty.service.dto.DtoService;
import com.zmf.realty.service.houseTypeImage.HouseTypeImageService;
import com.zmf.realty.service.projectImage.ProjectImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:32
 */
@RestController
@RequestMapping(value = "/api")
public class ImageController {
    @Autowired
    private ProjectImageService projectImageService;
    @Autowired
    private HouseTypeImageService houseTypeImageService;
    @Autowired
    private DtoService dtoService;
//    private Logger logger = LoggerFactory.getLogger(ImageController.class);

//    @IdDecryption
//    @GetMapping("/project/{id}")
//    public String getProjectImage(@PathVariable() String id, HttpServletResponse response) {
//        ProjectImage image = projectImageService.getImageById(id);
//        IoUtil.writeToOutput(response, image.getData());
//        return null;
//    }
//
//    @IdDecryption
//    @GetMapping("/house_type/{id}")
//    public String getHouseTypeImage(@PathVariable() String id, HttpServletResponse response) {
//        HouseTypeImage houseTypeImage = houseTypeImageService.getImageById(id);
//        IoUtil.writeToOutput(response, houseTypeImage.getData());
//        return null;
//    }

    @IdDecryption
    @PostMapping("/project_images/{projectId}")
    public String uploadProjectImage(@PathVariable String projectId,
                                     @RequestParam(value = "image") MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        ProjectImage image = projectImageService.insertImage(projectId, file, map);
        if (image == null) {
            return JSON.toJSONString(map);
        }
        return JSON.toJSONString(dtoService.buildImageDtoByProjectImageId(image.getImageId()));
    }

    @IdDecryption
    @DeleteMapping("/project_images/{imageId}")
    public String deleteProjectImage(@PathVariable String imageId) {
        ImageDto dto = dtoService.buildImageDtoByProjectImageId(imageId);
        projectImageService.deleteImage(imageId);
        return JSON.toJSONString(dto);
    }

//    @IdDecryption
//    @PostMapping("/project/{projectId}")
//    public String uploadProjectImage(@PathVariable String projectId, @RequestBody String requestBody) {
//        logger.info(requestBody);
//        return "null";
//    }

    @IdDecryption
    @PostMapping("/house_type_images/{houseTypeId}")
    public String uploadHouseTypeImage(@PathVariable String houseTypeId,
                                       @RequestParam(value = "image") MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        HouseTypeImage image = houseTypeImageService.insertImage(houseTypeId, file, map);
        if (image == null) {
            return JSON.toJSONString(map);
        }
        return JSON.toJSONString(dtoService.buildImageDtoByHouseTypeImageId(image.getImageId()));
    }

    @IdDecryption
    @DeleteMapping("/house_type_images/{imageId}")
    public String deleteHouseTypeImage(@PathVariable String imageId) {
        ImageDto dto = dtoService.buildImageDtoByHouseTypeImageId(imageId);
        houseTypeImageService.deleteImage(imageId);
        return JSON.toJSONString(dto);
    }
}
