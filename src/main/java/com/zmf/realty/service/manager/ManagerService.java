package com.zmf.realty.service.manager;

import com.zmf.realty.model.Manager;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-11 21:03
 */
public interface ManagerService {
    /**
     * insert a manager
     *
     * @param manager the instance
     */
    void insert(Manager manager);

    /**
     * delete the record by name
     *
     * @param name the name of the manager
     */
    void deleteByName(String name);

    /**
     * update the manager by name
     *
     * @param manager the instance
     */
    void updateByName(Manager manager);

    /**
     * is the manager valid
     *
     * @param manager the instance that contains name and password.
     * @return true if it's valid else false
     */
    boolean isValid(Manager manager);

    Manager buildManager(String name, String password);

    Manager buildManager(String requestBody);
}
