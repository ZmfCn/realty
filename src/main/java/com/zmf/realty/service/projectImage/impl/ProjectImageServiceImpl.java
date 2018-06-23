package com.zmf.realty.service.projectImage.impl;

import com.zmf.realty.dao.ProjectImageMapper;
import com.zmf.realty.model.ProjectImage;
import com.zmf.realty.service.file.FileService;
import com.zmf.realty.service.projectImage.ProjectImageService;
import com.zmf.realty.util.FileUtil;
import com.zmf.realty.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-17 22:37
 */
@Service
@Transactional
public class ProjectImageServiceImpl implements ProjectImageService {
    @Autowired
    private ProjectImageMapper projectImageDao;
    @Autowired
    private FileService fileService;

    @Override
    public ProjectImage insertImage(String projectId, MultipartFile file, Map<String, String> messages) {
        if (file == null || file.isEmpty()) {
            messages.put("error", "File is empty.");
            return null;
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image")) {
            messages.put("error", "It's not a image.");
            return null;
        }

        // generate file name
        String imageName = FileUtil.generateRawFileName() + FileUtil.getSuffix(contentType);
        String path = fileService.generateProjectImagePath(imageName);
        ProjectImage image = buildImage(projectId, path);
        projectImageDao.insert(image);
        FileUtil.writeFile(path, file);
        return image;
    }

    @Override
    public ProjectImage deleteImage(String imageId) {
        ProjectImage image = projectImageDao.selectByPrimaryKey(imageId);
        if (image == null) {
            return null;
        }
        projectImageDao.deleteByPrimaryKey(imageId);
        return image;
    }

    @Override
    public List<ProjectImage> getImagesByProjectId(String projectId) {
        return projectImageDao.getImagesByProjectId(projectId);
    }

    @Override
    public ProjectImage getImageById(String imageId) {
        return projectImageDao.selectByPrimaryKey(imageId);
    }

    @Override
    public ProjectImage buildImage(String projectId, String filePath) {
        ProjectImage image = new ProjectImage();
        image.setImageId(IdUtil.generateId());
        image.setFilepath(filePath);
        image.setProjectId(projectId);
        return image;
    }
}
