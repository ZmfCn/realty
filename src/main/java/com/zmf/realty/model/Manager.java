package com.zmf.realty.model;

public class Manager {
    /**
     * This field corresponds to the database column manager.manager_name
     *
     */
    private String managerName;

    /**
     * This field corresponds to the database column manager.manager_password
     *
     */
    private String managerPassword;

    /**
     * This method returns the value of the database column manager.manager_name
     *
     * @return the value of manager.manager_name
     *
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * This method sets the value of the database column manager.manager_name
     *
     * @param managerName the value for manager.manager_name
     *
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    /**
     * This method returns the value of the database column manager.manager_password
     *
     * @return the value of manager.manager_password
     *
     */
    public String getManagerPassword() {
        return managerPassword;
    }

    /**
     * This method sets the value of the database column manager.manager_password
     *
     * @param managerPassword the value for manager.manager_password
     *
     */
    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }
}