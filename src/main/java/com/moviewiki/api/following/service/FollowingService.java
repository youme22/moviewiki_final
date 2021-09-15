package com.moviewiki.api.following.service;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.user.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface FollowingService {
    // 팔로이 리스트 출력
    List<Following> followeeList(User fromUserId);

    // 팔로워 리스트 출력
    List<Following> followerList(User toUserId);

    // 팔로우 상태 확인
    Boolean isFollowing(User fromUserId, User toUserId);

    // 팔로워 수
    int countFollower(User toUserId);

    // 팔로잉 수
    int countFollowee(User fromUserId);

    // 팔로우
    Following followUser(String fromUserId, String toUserId);

}