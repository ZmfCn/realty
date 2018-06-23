package com.zmf.realty.service.file.impl;

import com.zmf.realty.service.file.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zmf
 * @description file service implementation
 * @timestamp 2018-06-14 21:47
 */
@Service
public class FileServiceImpl implements FileService {
    /**
     * the physical root path of project image root
     */
    @Value("${filepath.project-image-root-path}")
    private String projectImageRootPath;

    @Value("${filepath.house-type-image-root-path}")
    private String houseTypeImageRootPath;

    @Value("${filepath.www-service-root-path}")
    private String wwwServiceRootPath;

    @Value("${filepath.server-url-root}")
    private String serverUrlRoot;

    @Override
    public String generateProjectImagePath(String imageName) {
        return projectImageRootPath + "/" + imageName;
    }

    @Override
    public String generateHouseTypeImagePath(String imageName) {
        return houseTypeImageRootPath + "/" + imageName;
    }

    @Override
    public String mapImagePathToUrl(String imagePath) {
        String str = imagePath.replace(wwwServiceRootPath, "");
        return serverUrlRoot + str;
    }
}
