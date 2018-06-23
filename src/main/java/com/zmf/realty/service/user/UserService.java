package com.zmf.realty.service.user;

import com.zmf.realty.model.User;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-13 00:37
 */
public interface UserService {
    /**
     * insert user
     *
     * @param user user that contains all data
     */
    void insertUser(User user);

    /**
     * select user by open id
     *
     * @param openid openid from wechat
     * @return user
     */
    User selectUserByOpenid(String openid);

    /**
     * judge whether the user exists.
     *
     * @param openid open id
     * @return true if exists
     */
    boolean isUserExists(String openid);

    /**
     * update user by open id
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * build user instance
     *
     * @param openid    open id
     * @param name      name
     * @param telephone telephone
     * @return user instance
     */
    User buildUser(String openid, String name, String telephone);
}
