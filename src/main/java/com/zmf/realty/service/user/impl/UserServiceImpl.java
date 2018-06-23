package com.zmf.realty.service.user.impl;

import com.zmf.realty.dao.UserMapper;
import com.zmf.realty.model.User;
import com.zmf.realty.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-13 20:15
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public void insertUser(User user) {
        userDao.insert(user);
    }

    @Override
    public User selectUserByOpenid(String openid) {
        return userDao.selectByPrimaryKey(openid);
    }

    @Override
    public boolean isUserExists(String openid) {
        return userDao.selectByPrimaryKey(openid) != null;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public User buildUser(String openid, String name, String telephone) {
        User user = new User();
        user.setName(name);
        user.setTelephone(telephone);
        user.setUserOpenid(openid);
        return user;
    }
}
