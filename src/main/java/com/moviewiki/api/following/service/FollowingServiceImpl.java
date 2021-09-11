package com.moviewiki.api.following.service;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FollowingServiceImpl implements FollowingService {
    @Autowired
    FollowingRepository followingRepository;

    @Autowired
    UserRepository userRepository;

//    // 팔로우
//    @Transactional
//    @Override
//    public Following save(String fromUserId, String toUserId) {
//        User fromUser = userRepository.findByUserId(fromUserId);
//        User toUser = userRepository.findByUserId(toUserId);
//        return followingRepository.save(Following.builder()
//            .fromUser(fromUser)
//            .toUser(toUser)
//            .build());
//    }

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

}