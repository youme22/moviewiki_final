package com.moviewiki.api.following.repository;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.domain.FollowingPK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends JpaRepository<Following, String> {
    void deleteByFromUserAndToUser(String fromUser, String toUser);
    Following findByFromUserAndToUser(String fromUser, String toUser);
}
