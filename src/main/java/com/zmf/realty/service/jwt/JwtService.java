package com.zmf.realty.service.jwt;

import com.zmf.realty.model.Manager;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-11 18:56
 */
public interface JwtService {
    /**
     * create jwt according to the map provided
     *
     * @param manager the manager
     * @return jwt string
     */
    String createJwt(Manager manager);

    /**
     * get manager from jwt string return from client.
     *
     * @param jwt json web token string
     * @return the manger
     */
    Manager getManagerFromJwt(String jwt);

    /**
     * judge whether the jwt is valid.
     *
     * @param jwt jwt
     * @return true if it is else false.
     */
    boolean isValid(String jwt);
}
