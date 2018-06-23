package com.zmf.realty.test;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.apiDto.ProjectDto;
import com.zmf.realty.service.encryption.EncryptionService;
import com.zmf.realty.service.encryption.impl.EncryptionServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:03
 */
public class UUIDTest {
    @Test
    public void test(){
        EncryptionService encryptionService = new EncryptionServiceImpl();
        UUID uuid = UUID.randomUUID();
        System.out.println(encryptionService.decrypt(encryptionService.encrypt(uuid.toString())));
    }

    @Test
    public void testJSON(){
        Map<String,String> map = new HashMap<>();
        map.put("error", "file is empty");
        System.out.println(JSON.toJSON(map));
    }

    @Test
    public void test2(){
        System.out.println(JSON.toJSON(null));
    }
}
