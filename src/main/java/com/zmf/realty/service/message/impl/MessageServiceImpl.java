package com.zmf.realty.service.message.impl;

import com.alibaba.fastjson.JSONObject;
import com.zmf.realty.dao.MessageMapper;
import com.zmf.realty.model.Message;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.message.MessageService;
import com.zmf.realty.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-18 17:55
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageDao;
    @Autowired
    private EncryptionService encryptionService;

    @Override
    public void addMessage(Message message) {
        System.out.println(message.getContent());
        messageDao.insertSelective(message);
    }

    @Override
    public void deleteMessage(String messageId) {
        messageDao.deleteByPrimaryKey(messageId);
    }

    @Override
    public Message getMessage(String messageId) {
        return messageDao.selectByPrimaryKey(messageId);
    }

    @Override
    public List<Message> getAllUnreadMessages() {
        return null;
    }

    @Override
    public List<Message> getAllReadMessages() {
        return null;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    @Override
    public void setMessageRead(String messageId) {
    }

    @Override
    public Message buildMessage(String messageId, String projectId, String content, String phone, String call, boolean isRead) {
        Message message = new Message();
        message.setMessageId(messageId);
        message.setProjectId(projectId);
        message.setContent(content);
        message.setPhone(phone);
        message.setCall(call);
        message.setIsReaded(false);
        return message;
    }

    @Override
    public Message buildMessage(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        return buildMessage(IdUtil.generateId(),
                encryptionService.decrypt(jsonObject.getString("project_id")),
                jsonObject.getString("content"), jsonObject.getString("phone"),
                jsonObject.getString("call"), false);
    }
}
