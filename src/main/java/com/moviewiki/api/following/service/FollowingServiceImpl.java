package com.moviewiki.api.following.service;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.domain.FollowingPK;
import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.repository.UserRepository;
import com.moviewiki.api.user.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FollowingServiceImpl implements FollowingService {
    @Autowired
    FollowingRepository followingRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public void unfollowUser(String fromUserId, String toUserId) {
        followingRepository.deleteByFromUserAndToUser(fromUserId, toUserId);
    }

//    @Override
//    public Following getFollowUser(String fromUserId, String toUserId) {
////        User fromUser = userRepository.findByUserId(fromUserId);
////        User toUser = userRepository.findByUserId(toUserId);
//
//        Following following = followingRepository.findByFromUserAndToUser(fromUserId, toUserId);
//
//        return following;
//    }

    /* 팔로우 정보를 저장 후 저장된 정보 반환
            fromUserId : 로그인 사용자의 userId
            toUserId : 팔로우할 프로필의 userId
        */

    @Transactional
    @Override
    public Following followUser(String fromUserId, String toUserId) {
        User fromUser = userRepository.findByUserId(fromUserId);
        User toUser = userRepository.findByUserId(toUserId);

        return followingRepository.save(Following.builder()
                .fromUser(fromUser)
                .toUser(toUser)
                .build());
    }
}

