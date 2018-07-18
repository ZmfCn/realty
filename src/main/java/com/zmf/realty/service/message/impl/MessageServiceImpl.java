package com.zmf.realty.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zmf.realty.dao.MessageMapper;
import com.zmf.realty.model.Message;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.message.MessageService;
import com.zmf.realty.util.IdUtil;
import com.zmf.realty.whereCondition.MessageWhereCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public List<Message> getMessagesByCondition(MessageWhereCondition condition) {
        return messageDao.selectMessageByCondition(condition);
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
    public void setMessageRead(String messageId, String requestBody) {
        Message message = new Message();
        JSONObject jsonObject = JSON.parseObject(requestBody);
        message.setIsRead(Boolean.valueOf(jsonObject.getString("is_read")));
        message.setMessageId(messageId);
        messageDao.updateByPrimaryKeySelective(message);
    }

    @Override
    public Message buildMessage(String messageId, String projectId, String content, String phone, String call, boolean isRead) {
        Message message = new Message();
        message.setMessageId(messageId);
        message.setProjectId(projectId);
        message.setContent(content);
        message.setPhone(phone);
        message.setCall(call);
        message.setIsRead(false);
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

    @Override
    public MessageWhereCondition buildSearchCondition(String requestBody) {
        JSONObject jsonObject = JSON.parseObject(requestBody);
        MessageWhereCondition condition = new MessageWhereCondition();
        condition.setPhone(jsonObject.getString("phone"));
        String isRead = jsonObject.getString("is_read");
        if (isRead != null) {
            condition.setReadEmpty(false);
            condition.setIsRead(Boolean.valueOf(isRead));
        } else {
            condition.setReadEmpty(true);
        }
        condition.setContent(jsonObject.getString("content"));
        condition.setCall(jsonObject.getString("call"));
        String projectId = jsonObject.getString("project_id");
        condition.setProjectId(projectId == null ? null : encryptionService.decrypt(projectId));
        try {
            String date = jsonObject.getString("after");
            condition.setAfter(date == null ? null : new Timestamp(new SimpleDateFormat("yyyy-mm-dd").parse(date).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return condition;
    }
}
