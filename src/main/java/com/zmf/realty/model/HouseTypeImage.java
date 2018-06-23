package com.zmf.realty.model;

public class HouseTypeImage {
    /**
     * This field corresponds to the database column house_type_image.image_id
     *
     */
    private String imageId;

    /**
     * This field corresponds to the database column house_type_image.filepath
     *
     */
    private String filepath;

    /**
     * This field corresponds to the database column house_type_image.house_type_id
     *
     */
    private String houseTypeId;

    /**
     * This method returns the value of the database column house_type_image.image_id
     *
     * @return the value of house_type_image.image_id
     *
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * This method sets the value of the database column house_type_image.image_id
     *
     * @param imageId the value for house_type_image.image_id
     *
     */
    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    /**
     * This method returns the value of the database column house_type_image.filepath
     *
     * @return the value of house_type_image.filepath
     *
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * This method sets the value of the database column house_type_image.filepath
     *
     * @param filepath the value for house_type_image.filepath
     *
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    /**
     * This method returns the value of the database column house_type_image.house_type_id
     *
     * @return the value of house_type_image.house_type_id
     *
     */
    public String getHouseTypeId() {
        return houseTypeId;
    }

    /**
     * This method sets the value of the database column house_type_image.house_type_id
     *
     * @param houseTypeId the value for house_type_image.house_type_id
     *
     */
    public void setHouseTypeId(String houseTypeId) {
        this.houseTypeId = houseTypeId == null ? null : houseTypeId.trim();
    }
}