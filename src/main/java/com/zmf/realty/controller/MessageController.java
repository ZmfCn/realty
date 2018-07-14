package com.zmf.realty.controller;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.annotation.IdDecryption;
import com.zmf.realty.apiDto.MessageDto;
import com.zmf.realty.model.Message;
import com.zmf.realty.service.dto.DtoService;
import com.zmf.realty.service.jwt.JwtService;
import com.zmf.realty.service.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-11 21:32
 */
@RestController
@RequestMapping(value = "/api/messages", produces = "application/json;charset=utf-8")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private DtoService dtoService;
    @Autowired
    private JwtService jwtService;
    private Logger logger = LoggerFactory.getLogger(MessageController.class);

    @GetMapping
    public String getAllMessages() {
        return JSON.toJSONString(dtoService.buildMessageDtos());
    }

    @PostMapping()
    public String addMessage(@RequestBody String requestBody) {
        Message message = messageService.buildMessage(requestBody);
        messageService.addMessage(message);
        return JSON.toJSONString(dtoService.buildMessageDto(message.getMessageId()));
    }

    @IdDecryption
    @DeleteMapping(value = "/{messageId}")
    public String deleteMessage(@PathVariable String messageId) {
        MessageDto dto = dtoService.buildMessageDto(messageId);
        messageService.deleteMessage(messageId);
        return JSON.toJSONString(dto);
    }

    @IdDecryption
    @GetMapping(value = "/{messageId}")
    public String getMessage(@PathVariable String messageId) {
        return JSON.toJSONString(dtoService.buildMessageDto(messageId));
    }

    @IdDecryption
    @PutMapping(value = "/{messageId}")
    public String setMessageRead(@PathVariable String messageId, @RequestBody String requestBody) {
        messageService.setMessageRead(messageId, requestBody);
        return JSON.toJSONString(dtoService.buildMessageDto(messageId));
    }
}
