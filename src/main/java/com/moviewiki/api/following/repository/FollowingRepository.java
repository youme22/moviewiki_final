package com.moviewiki.api.following.repository;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.domain.FollowingPK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FollowingRepository extends JpaRepository<Following, FollowingPK> {
    // 팔로워 리스트
    List<Following> findFromUserByToUser(User toUserId);

    // 팔로잉 리스트
    List<Following> findToUserByFromUser(User fromUserId);

    // 팔로워 수
    int countByFromUser_UserId(User fromUserId);

    // 팔로이 수
    int countByToUser_UserId(User toUserId);
}