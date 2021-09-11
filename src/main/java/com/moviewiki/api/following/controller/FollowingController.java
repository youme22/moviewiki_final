package com.moviewiki.api.following.controller;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.service.FollowingService;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowingController {

    @Autowired
    FollowingService followingService;

    @Autowired
    UserManagementService userManagementService;

    /* follow 기능
        fromuserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 추가
        toUserId : 팔로우 당하는 유저의 id
        return  새로 생성된 follow 객체 리턴
     */
    @PostMapping("/following/{toUserId}")
    public Following followUser(@PathVariable String toUserId, Authentication authentication) {
        return followingService.followUser(authentication.getName(), toUserId);
    }

    /* unfollow 기능
        fromuserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 삭제
        @toUserId : 언팔로우 당하는 유저의 id
     */
    @DeleteMapping("/following/{toUserId}")
    public void unfollowUser(@PathVariable String toUserId, Authentication authentication) {
        // fromUserId, toUserId 두개가 PK이므로 두개 삭제?
        String fromUserId = authentication.getName();

        followingService.unfollowUser(fromUserId, toUserId);
    }

    // follow 페이지 call
    @GetMapping("/member/followList/{userId}")
    public String followPage(@PathVariable String userId, Model model) {
//        List<Following> follwingUsers = userManagementService.getFollowingUser

        User user = userManagementService.getUser(userId);
        model.addAttribute("user", user);
        return "/member/my_following";
    }
}
