package com.zmf.realty.util;

import java.util.UUID;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-15 23:10
 */
public class IdUtil {
    /**
     * generate a new id
     *
     * @return the unique id
     */
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
