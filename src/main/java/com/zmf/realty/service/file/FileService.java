package com.zmf.realty.service.file;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-14 21:46
 */
public interface FileService {
    /**
     * generate physical image path
     *
     * @param imageName image file name
     * @return file path
     */
    String generateProjectImagePath(String imageName);

    /**
     * generate physical image path
     *
     * @param imageName image file name
     * @return file path
     */
    String generateHouseTypeImagePath(String imageName);

    /**
     * map the image path to url of www service
     *
     * @param imagePath image path
     * @return url
     */
    String mapImagePathToUrl(String imagePath);
}
