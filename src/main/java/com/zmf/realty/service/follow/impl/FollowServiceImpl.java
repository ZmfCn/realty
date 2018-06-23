package com.zmf.realty.service.follow.impl;

import com.zmf.realty.dao.FollowMapper;
import com.zmf.realty.model.Follow;
import com.zmf.realty.service.follow.FollowService;
import com.zmf.realty.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-18 16:31
 */
@Service
@Transactional
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followDao;

    @Override
    public void insertFollow(Follow follow) {
        followDao.insert(follow);
    }

    @Override
    public void deleteFollowById(String followId) {
        followDao.deleteByPrimaryKey(followId);
    }

    @Override
    public int getFollowAmountByProjectId(String projectId) {
        return followDao.getFollowAmountByProjectId(projectId);
    }

    @Override
    public Follow buildFollow(String userOpenid, String projectId) {
        Follow follow = new Follow();
        follow.setFollowId(IdUtil.generateId());
        follow.setProjectId(projectId);
        follow.setUserOpenid(userOpenid);
        return null;
    }
}
