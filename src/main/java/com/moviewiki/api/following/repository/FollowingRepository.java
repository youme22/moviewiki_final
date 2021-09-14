package com.moviewiki.api.following.repository;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.domain.FollowingPK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FollowingRepository extends JpaRepository<Following, FollowingPK> {
    //    void deleteByFromUserAndToUser(String fromUser, String toUser);
//    Following findByFromUserAndToUser(String fromUser, String toUser);
//    List<Following> findFolloweeByFollowerId(String followerId);
    List<Following> findFromUserByToUser(User ToUserId);
    List<Following> findToUserByFromUser(User fromUserId);


// List<User> findFolloweeByFollowerId(String followerId);
// 민형님 저는 메소드 쓰는거 이거밖에 없으니 참고하세요.
// 그리고 샘플데이터랑 일치하게 필드명 바꾸는게 좋을 것 같아요. -효미

}