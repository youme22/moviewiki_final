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

    // 팔로워되어있는지 확인
    boolean existsByFromUserAndAndToUser(User fromUserId, User toUserId);

    // 팔로워 수
    int countFromUserByToUser(User toUserId);

    // 팔로잉 수
    int countToUserByFromUser(User fromUserId);

  // List<User> findFolloweeByFollower(User follower);
// 민형님 저는 메소드 쓰는거 이거밖에 없으니 참고하세요.
// 그리고 샘플데이터랑 일치하게 필드명 바꾸는게 좋을 것 같아요. -효미

}