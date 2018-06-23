package com.zmf.realty.service.houseTypeImage.impl;

import com.zmf.realty.dao.HouseTypeImageMapper;
import com.zmf.realty.model.HouseType;
import com.zmf.realty.model.HouseTypeImage;
import com.zmf.realty.model.ProjectImage;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.file.FileService;
import com.zmf.realty.service.houseTypeImage.HouseTypeImageService;
import com.zmf.realty.util.FileUtil;
import com.zmf.realty.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-17 18:57
 */
@Service
@Transactional
public class HouseTypeImageServiceImpl implements HouseTypeImageService {
    @Autowired
    private HouseTypeImageMapper houseTypeImageDao;
    @Autowired
    private FileService fileService;

    @Override
    public HouseTypeImage insertImage(String houseTypeId, MultipartFile file, Map<String, String> messages) {
        if (file == null || file.isEmpty()) {
            messages.put("error", "File is empty.");
            return null;
        }

        String contentType = file.getContentType();
        if (contentType == null || contentType.startsWith("image")) {
            messages.put("error", "It's not a image.");
            return null;
        }

        // generate file name
        String imageName = FileUtil.generateRawFileName() + FileUtil.getSuffix(contentType);
        String path = fileService.generateHouseTypeImagePath(imageName);
        HouseTypeImage image = buildImage(houseTypeId, path);
        houseTypeImageDao.insert(image);
        FileUtil.writeFile(path, file);
        return image;
    }

    @Override
    public HouseTypeImage deleteImage(String imageId) {
        HouseTypeImage image = getImageById(imageId);
        if (image == null) {
            return null;
        }
        houseTypeImageDao.deleteByPrimaryKey(imageId);
        FileUtil.deleteFile(new File(image.getFilepath()));
        return image;
    }

    @Override
    public List<HouseTypeImage> getImagesByHouseTypeId(String typeId) {
        return houseTypeImageDao.getImagesByHouseTypeId(typeId);
    }

    @Override
    public HouseTypeImage getImageById(String imageId) {
        return houseTypeImageDao.selectByPrimaryKey(imageId);
    }

    @Override
    public HouseTypeImage buildImage(String houseTypeId, String filePath) {
        HouseTypeImage image = new HouseTypeImage();
        image.setFilepath(filePath);
        image.setHouseTypeId(houseTypeId);
        image.setImageId(IdUtil.generateId());
        return image;
    }
}
