package com.zmf.realty.service.dto.impl;

import com.zmf.realty.apiDto.HouseTypeDto;
import com.zmf.realty.apiDto.ImageDto;
import com.zmf.realty.apiDto.MessageDto;
import com.zmf.realty.apiDto.ProjectDto;
import com.zmf.realty.dao.MessageMapper;
import com.zmf.realty.dao.ProjectImageMapper;
import com.zmf.realty.dao.ProjectMapper;
import com.zmf.realty.model.*;
import com.zmf.realty.service.dto.DtoService;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.file.FileService;
import com.zmf.realty.service.follow.FollowService;
import com.zmf.realty.service.houseType.HouseTypeService;
import com.zmf.realty.service.houseTypeImage.HouseTypeImageService;
import com.zmf.realty.service.project.ProjectService;
import com.zmf.realty.service.projectImage.ProjectImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-17 16:31
 */
@Service
public class DtoServiceImpl implements DtoService {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectImageService projectImageService;
    @Autowired
    private HouseTypeService houseTypeService;
    @Autowired
    private HouseTypeImageService houseTypeImageService;
    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private FollowService followService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ProjectMapper projectDao;
    @Autowired
    private ProjectImageMapper projectImageDao;
    @Autowired
    private MessageMapper messageDao;

    @Override
    public List<ProjectDto> buildAllProjectDto() {
        List<ProjectWithBLOBs> projects = projectService.getAllProjects();
        if (projects == null) {
            return null;
        }
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (ProjectWithBLOBs project : projects) {
            projectDtos.add(convertFromProjectToDto(project));
        }
        return projectDtos;
    }


    @Override
    public ProjectDto buildCertainProjectDto(String projectId) {
        ProjectWithBLOBs project = projectService.selectProjectById(projectId);
        return convertFromProjectToDto(project);
    }

    @Override
    public HouseTypeDto buildHouseTypeDto(String houseTypeId) {
        HouseType houseType = houseTypeService.selectHouseTypeById(houseTypeId);
        return convertFromHouseTypeToDto(houseType);
    }

    @Override
    public MessageDto buildMessageDto(String messageId) {
        return convertFromMessage(messageDao.selectByPrimaryKey(messageId));
    }

    @Override
    public ImageDto buildImageDtoByProjectImageId(String projectImageId) {
        return convertFromProjectImage(projectImageService.getImageById(projectImageId));
    }

    @Override
    public ImageDto buildImageDtoByHouseTypeImageId(String houseTypeImageId) {
        return convertFromHouseTypeImage(houseTypeImageService.getImageById(houseTypeImageId));
    }

    @Override
    public List<MessageDto> buildMessageDtos() {
        List<Message> messages = messageDao.getAllMessages();
        List<MessageDto> dtos = new ArrayList<>();
        for (Message message : messages) {
            dtos.add(convertFromMessage(message));
        }
        return dtos;
    }

    @Override
    public List<ImageDto> buildCarousels() {
        List<ProjectWithBLOBs> projects = projectDao.getProjectsToShow();
        List<ProjectImage> images = new ArrayList<>();
        for (ProjectWithBLOBs project : projects) {
            images.add(projectImageDao.getFirstImageByProjectId(project.getProjectId()));
        }
        return convertFromProjectImageList(images);
    }

    /**
     * convert house type to dto
     *
     * @param houseType house type
     * @return dto
     */
    private HouseTypeDto convertFromHouseTypeToDto(HouseType houseType) {
        if (houseType == null) {
            return null;
        }
        HouseTypeDto dto = new HouseTypeDto();
        dto.setCarousels(convertFromHouseTypeImageList(houseTypeImageService.getImagesByHouseTypeId(houseType.getTypeId())));
        dto.setDecoration(houseType.getDecoration());
        dto.setDiscount(houseType.getDiscount());
        dto.setName(houseType.getName());
        dto.setOrientation(houseType.getOrientation());
        dto.setPrice(houseType.getPrice());
        dto.setReason(houseType.getReason());
        dto.setSize(houseType.getSize());
        dto.setTags(convertFromTagsToList(houseType.getTags()));
        dto.setTelephone(houseType.getTelephone());
        dto.setTypeId(encryptionService.encrypt(houseType.getTypeId()));
        dto.setProjectId(encryptionService.encrypt(houseType.getProjectId()));
        return dto;
    }

    /**
     * convert project to dto
     *
     * @param project project
     * @return dto
     */
    private ProjectDto convertFromProjectToDto(ProjectWithBLOBs project) {
        if (project == null) {
            return null;
        }
        ProjectDto dto = new ProjectDto();
        dto.setAddress(project.getAddress());
        dto.setCarousels(convertFromProjectImageList(projectImageService.getImagesByProjectId(project.getProjectId())));
        dto.setDealAmount(project.getDealAmount());
        dto.setFollowAmount(followService.getFollowAmountByProjectId(project.getProjectId()));
        dto.setDetail(project.getDetail());
        dto.setName(project.getName());
        dto.setReason(project.getReason());
        dto.setTags(convertFromTagsToList(project.getTags()));
        dto.setTelephone(project.getTelephone());
        dto.setPrice(project.getPrice());
        dto.setSize(project.getSize());
        dto.setProjectId(encryptionService.encrypt(project.getProjectId()));
        dto.setLocation(project.getLocation());
        dto.setHouseTypeIds(convertFromHouseTypeList(houseTypeService.getAllHouseTypesByProjectId(project.getProjectId())));
        dto.setShow(project.getIsShow());
        List<String> messageIds = messageDao.getAllMessageIdsByProjectId(project.getProjectId());
        List<String> encrypted = new ArrayList<>();
        for (String messageId: messageIds) {
            encrypted.add(encryptionService.encrypt(messageId));
        }
        dto.setMessageIds(encrypted);
        return dto;
    }

    private List<ImageDto> convertFromProjectImageList(List<ProjectImage> images) {
        if (images == null) {
            return null;
        }
        List<ImageDto> carousels = new ArrayList<>();
        for (ProjectImage image : images) {
            carousels.add(convertFromProjectImage(image));
        }
        return carousels;
    }

    private List<ImageDto> convertFromHouseTypeImageList(List<HouseTypeImage> images) {
        if (images == null) {
            return null;
        }
        List<ImageDto> carousels = new ArrayList<>();
        for (HouseTypeImage image : images) {
            carousels.add(convertFromHouseTypeImage(image));
        }
        return carousels;
    }

    private List<String> convertFromHouseTypeList(List<HouseType> houseTypes) {
        if (houseTypes == null) {
            return null;
        }
        List<String> types = new ArrayList<>();
        for (HouseType type : houseTypes) {
            types.add(encryptionService.encrypt(type.getTypeId()));
        }
        return types;
    }

    private List<String> convertFromTagsToList(String tags) {
        if (tags == null) {
            return new ArrayList<>();
        }
        if (tags.trim().length() == 0) {
            return new ArrayList<>();
        }
        tags = tags.replaceAll("，", ",");
        return Arrays.asList(tags.split(","));
    }

    private ImageDto convertFromProjectImage(ProjectImage projectImage) {
        ImageDto dto = new ImageDto();
        dto.setUrl(fileService.mapImagePathToUrl(projectImage.getFilepath()));
        dto.setImageId(encryptionService.encrypt(projectImage.getImageId()));
        dto.setProjectId(encryptionService.encrypt(projectImage.getProjectId()));
        return dto;
    }

    private ImageDto convertFromHouseTypeImage(HouseTypeImage houseTypeImage) {
        ImageDto dto = new ImageDto();
        dto.setUrl(fileService.mapImagePathToUrl(houseTypeImage.getFilepath()));
        dto.setImageId(encryptionService.encrypt(houseTypeImage.getImageId()));
        return dto;
    }

    private MessageDto convertFromMessage(Message message) {
        MessageDto dto = new MessageDto();
        ProjectWithBLOBs project = projectDao.selectByPrimaryKey(message.getProjectId());
        dto.setCall(message.getCall());
        dto.setTime(message.getDatetime().toString());
        dto.setProjectId(encryptionService.encrypt(message.getProjectId()));
        dto.setPhone(message.getPhone());
        dto.setMessageId(encryptionService.encrypt(message.getMessageId()));
        dto.setRead(message.getIsReaded());
        dto.setContent(message.getContent());
        dto.setProjectName(project.getName());
        return dto;
    }
}
