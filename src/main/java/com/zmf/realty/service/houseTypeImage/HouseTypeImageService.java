package com.zmf.realty.service.houseTypeImage;

import com.zmf.realty.model.HouseTypeImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-14 21:28
 */
public interface HouseTypeImageService {
    /**
     * insert a new image to the database
     *
     * @param houseTypeId house type id
     * @param file        file
     * @param messages    message container
     */
    HouseTypeImage insertImage(String houseTypeId, MultipartFile file, Map<String, String> messages);

    /**
     * delete the image by id
     *
     * @param imageId the image id
     */
    HouseTypeImage deleteImage(String imageId);

    /**
     * get images of house type by type id
     *
     * @param typeId the type id
     * @return images
     */
    List<HouseTypeImage> getImagesByHouseTypeId(String typeId);

    /**
     * get image by id
     *
     * @param imageId image id
     * @return image
     */
    HouseTypeImage getImageById(String imageId);

    /**
     * build instance of the HouseTypeImage
     *
     * @param houseTypeId house type id
     * @param filePath    the logical address
     * @return image
     */
    HouseTypeImage buildImage(String houseTypeId, String filePath);
}
