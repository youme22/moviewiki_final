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
    public List<Following> followeeList(User follower) {
        List<Following> followeeList = followingRepository.findFolloweeByFollower(follower);
        return followeeList;
    }

    // 팔로워 리스트 출력
    @Override
    public List<Following> followerList(User followee) {
        List<Following> followerList = followingRepository.findFollowerByFollowee(followee);
        return followerList;
    }

    // 팔로우 상태 확인
    @Override
    public Boolean isFollowing(User follower, User followee) {
        return followingRepository.existsByFollowerAndFollowee(follower, followee);
    }

    // 팔로워 수
    @Override
    public int countFollower(User followee) {
        return followingRepository.countFollowerByFollowee(followee);
    }

    // 팔로잉 수
    @Override
    public int countFollowee(User follower) {
        return followingRepository.countFolloweeByFollower(follower);
    }

    // 팔로우
    @Override
    @Transactional
    public Following followUser(String followerId, String followeeId) {
        User follower = userManagementService.getUser(followerId);
        User followee = userManagementService.getUser(followeeId);
        log.info("follower =========== " + follower);
        log.info("followee =========== " + followee);
        return followingRepository.save(Following.builder()
            .follower(follower)
            .followee(followee)
            .build());
    }
}