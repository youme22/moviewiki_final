package com.moviewiki.api.following.service;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.user.controller.UserManagementController;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FollowingServiceImpl implements FollowingService {
    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    FollowingRepository followingRepository;

    @Autowired
    UserManagementService userManagementService;


    // 팔로잉 리스트 출력
    @Override
    public List<Following> followeeList(User fromUserId) {
        List<Following> followeeList = followingRepository.findToUserByFromUser(fromUserId);
        return followeeList;
    }

    // 팔로워 리스트 출력
    @Override
    public List<Following> followerList(User toUserId) {
        List<Following> followerList = followingRepository.findFromUserByToUser(toUserId);
        return followerList;
    }

    // 팔로우 상태 확인
    @Override
    public Boolean isFollowing(User fromUserId, User toUserId) {
        return followingRepository.existsByFromUserAndAndToUser(fromUserId, toUserId);
    }

    // 팔로우
    @Override
    @Transactional
    public Following followUser(String fromUserId, String toUserId) {
        User fromUser = userManagementService.getUser(fromUserId);
        User toUser = userManagementService.getUser(toUserId);
        log.info("fromUser =========== " + fromUser);
        log.info("toUser =========== " + toUser);
        return followingRepository.save(Following.builder()
            .fromUser(fromUser)
            .toUser(toUser)
            .build());
    }
}