package com.moviewiki.api.following.service;

import com.moviewiki.api.following.domain.Following;
import org.springframework.stereotype.Service;

@Service
public interface FollowingService {
    Following followUser(String fromUserId, String toUserId);

    void unfollowUser(String fromUserId, String toUserId);
}
