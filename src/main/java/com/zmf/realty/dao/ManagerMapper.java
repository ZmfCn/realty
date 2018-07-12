package com.zmf.realty.dao;

import com.zmf.realty.model.Manager;

public interface ManagerMapper {
    /**
     * This method corresponds to the database table manager
     */
    int deleteByPrimaryKey(String managerName);

    /**
     * This method corresponds to the database table manager
     */
    int insert(Manager record);

    /**
     * This method corresponds to the database table manager
     */
    Manager selectByPrimaryKey(String managerName);

    /**
     * select manager by name and password
     *
     * @param manager manager
     * @return manager
     */
    Manager selectByManager(Manager manager);

    /**
     * This method corresponds to the database table manager
     */
    int updateByPrimaryKeySelective(Manager record);
}