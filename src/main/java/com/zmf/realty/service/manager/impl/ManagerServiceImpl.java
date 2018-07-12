package com.zmf.realty.service.manager.impl;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.dao.ManagerMapper;
import com.zmf.realty.model.Manager;
import com.zmf.realty.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-11 21:07
 */
@Transactional
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerDao;


    @Override
    public void insert(Manager manager) {
        managerDao.insert(manager);
    }

    @Override
    public void deleteByName(String name) {
        managerDao.deleteByPrimaryKey(name);
    }

    @Override
    public void updateByName(Manager manager) {
        managerDao.updateByPrimaryKeySelective(manager);
    }

    @Override
    public boolean isValid(Manager manager) {
        return manager != null && manager.getManagerName() != null && manager.getManagerPassword() != null
                && managerDao.selectByManager(manager) != null;
    }

    @Override
    public Manager buildManager(String name, String password) {
        Manager manager = new Manager();
        manager.setManagerName(name);
        manager.setManagerPassword(password);
        return manager;
    }

    @Override
    public Manager buildManager(String requestBody) {
        return buildManager("root", JSON.parseObject(requestBody).getString("password"));
    }
}
