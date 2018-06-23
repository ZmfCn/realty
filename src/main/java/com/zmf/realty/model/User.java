package com.zmf.realty.model;

public class User {
    /**
     * This field corresponds to the database column user.user_openid
     *
     */
    private String userOpenid;

    /**
     * This field corresponds to the database column user.name
     *
     */
    private String name;

    /**
     * This field corresponds to the database column user.telephone
     *
     */
    private String telephone;

    /**
     * This method returns the value of the database column user.user_openid
     *
     * @return the value of user.user_openid
     *
     */
    public String getUserOpenid() {
        return userOpenid;
    }

    /**
     * This method sets the value of the database column user.user_openid
     *
     * @param userOpenid the value for user.user_openid
     *
     */
    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    /**
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column user.telephone
     *
     * @return the value of user.telephone
     *
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method sets the value of the database column user.telephone
     *
     * @param telephone the value for user.telephone
     *
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }
}