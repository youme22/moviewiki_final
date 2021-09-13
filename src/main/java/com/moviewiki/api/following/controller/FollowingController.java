package com.moviewiki.api.following.controller;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.domain.FollowingPK;
import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.following.service.FollowingService;
import com.moviewiki.api.user.controller.UserManagementController;
import com.moviewiki.api.user.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FollowingController {
    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    FollowingRepository followingRepository;

    @Autowired
    FollowingService followingService;

    @Autowired
    UserManagementService userManagementService;

    /* follow 기능
        fromuserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 추가
        toUserId : 팔로우 당하는 유저의 id
        return  새로 생성된 follow 객체 리턴
     */
//    @PostMapping("/following/{toUserId}")
//    public Following followUser(@PathVariable String toUserId, Authentication authentication) {
//        return followingService.save(authentication.getName(), toUserId);
//    }

    /* unfollow 기능
        fromuserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 삭제
        @toUserId : 언팔로우 당하는 유저의 id
     */
//    @DeleteMapping("/following/{toUserId}")
//    public void unfollowUser(@PathVariable String toUserId, Authentication authentication) {
//        // fromUserId, toUserId 두개가 PK이므로 두개 삭제?
//        String userId = followingService.getFollowIdByFromEmailToId(authentication.getName(), toUserId);
//        followingPK.
//        followingRepository.deleteById(userId);
//    }

}