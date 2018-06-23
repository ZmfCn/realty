package com.zmf.realty.service.projectImage;

import com.zmf.realty.model.ProjectImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 14:44
 */
public interface ProjectImageService {
    /**
     * insert a new image to the database
     *
     * @param projectId project id
     * @param file      file
     * @param messages  message container
     * @return image
     */
    ProjectImage insertImage(String projectId, MultipartFile file, Map<String, String> messages);

    /**
     * delete the image by id
     *
     * @param imageId the image id
     * @return image
     */
    ProjectImage deleteImage(String imageId);

    /**
     * get images of project by project id
     *
     * @param projectId the project id
     * @return result
     */
    List<ProjectImage> getImagesByProjectId(String projectId);


    /**
     * get image by id
     *
     * @param imageId image id
     * @return image
     */
    ProjectImage getImageById(String imageId);

    /**
     * build instance of the ProjectImage
     *
     * @param projectId project id
     * @param filePath  the logical address
     * @return instance
     */
    ProjectImage buildImage(String projectId, String filePath);
}
