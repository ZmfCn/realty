package com.zmf.realty.service.follow;

import com.zmf.realty.model.Follow;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-14 19:16
 */
public interface FollowService {
    /**
     * insert follow
     *
     * @param follow follow that contains all values
     */
    void insertFollow(Follow follow);

    /**
     * deleteFollowById
     *
     * @param followId the id of follow
     */
    void deleteFollowById(String followId);

//    /**
//     * delete all follows by the project id
//     *
//     * @param projectId the id of project
//     */
//    void deleteFollowsByProjectId(String projectId);


    /**
     * get the amount of follow by the project id
     *
     * @param projectId the id of project
     * @return the amount
     */
    int getFollowAmountByProjectId(String projectId);

    /**
     * build an instance according to the values
     *
     * @param userOpenid user openid
     * @param projectId  project id
     * @return the instance
     */
    Follow buildFollow(String userOpenid, String projectId);
}
