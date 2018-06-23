package com.zmf.realty.service.message.impl;

import com.zmf.realty.model.Message;
import com.zmf.realty.service.message.MessageService;
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
    @Override
    public void addMessage(Message message) {

    }

    @Override
    public void deleteMessage(String messageId) {

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
    public void setMessageRead(String messageId) {

    }

    @Override
    public Message buildMessage(String openid, String content, Boolean isReaded, String houseTypeId) {
        return null;
    }
}
