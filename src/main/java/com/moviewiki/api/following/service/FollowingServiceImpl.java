package com.moviewiki.api.following.service;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingServiceImpl implements FollowingService {
    @Autowired
    FollowingRepository followingRepository;

    @Autowired
    UserRepository userRepository;


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
}