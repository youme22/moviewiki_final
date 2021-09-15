package com.moviewiki.api.following.controller;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.service.FollowingService;
import com.moviewiki.api.user.controller.UserManagementController;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FollowingController {
    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    FollowingService followingService;

    // 팔로잉 리스트 출력, form call
    @RequestMapping("/member/followeeList/{userId}")
    public String followeePage(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        User pageUser = userManagementService.getUser(userId);
        User loginUser = userManagementService.getUser(currentUser.getUsername());
        List<Following> followeeList = followingService.followeeList(pageUser);






        model.addAttribute("isFollowing", followingService.isFollowing(loginUser, pageUser));


        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("followeeList", followeeList);
        return "/member/followee";
    }

    // 팔로워 리스트 출력, form call
    @RequestMapping("/member/followerList/{userId}")
    public String followerPage(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        User follower = userManagementService.getUser(currentUser.getUsername());
        User followee = userManagementService.getUser(userId);
        List<Following> followerList = followingService.followerList(followee);


        model.addAttribute("isFollowing", followingService.isFollowing(follower, followee));
        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("followerList", followerList);
        return "/member/follower";
    }



    /* follow 기능
        fromUserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 추가
        toUserId : 팔로우 당하는 유저의 id
        return  새로 생성된 follow 객체 리턴
     */
    @PostMapping("/follow/{userId}")
    public Following followUser(@PathVariable String userId, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {

        User fromUser = userManagementService.getUser(currentUser.getUsername());
        User toUser = userManagementService.getUser(userId);
        log.info("fromUser ======" + fromUser);
        log.info("userId ======" + toUser);
        return followingService.followUser(fromUser, toUser);
    }


    /* unfollow 기능
        fromuserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 삭제
        @toUserId : 언팔로우 당하는 유저의 id
     */

}
