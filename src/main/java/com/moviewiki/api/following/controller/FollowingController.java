package com.moviewiki.api.following.controller;

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

import javax.servlet.http.HttpServletRequest;

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
        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("followeeList", followingService.followeeList(pageUser));
        return "/member/followee";
    }

    // 팔로워 리스트 출력, form call
    @RequestMapping("/member/followerList/{userId}")
    public String followerPage(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        User pageUser = userManagementService.getUser(userId);
        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("followerList", followingService.followerList(pageUser));
        return "/member/follower";
    }

    // 팔로우 기능
    @PostMapping("/follow")
    public String followUser(HttpServletRequest request) {
        String followerId = request.getParameter("followerId");
        String followeeId = request.getParameter("followeeId");

        User follower = userManagementService.getUser(followerId);
        User followee = userManagementService.getUser(followeeId);

        followingService.followUser(follower, followee);

        return "redirect:/member/mypage/" + followeeId;
    }


    // 언팔로우 기능
    @RequestMapping("/unfollow")
    public String unfollowUser(HttpServletRequest request) {
        String followerId = request.getParameter("followerId");
        String followeeId = request.getParameter("followeeId");

        User follower = userManagementService.getUser(followerId);
        User followee = userManagementService.getUser(followeeId);

        followingService.unfollowUser(follower, followee);

        return "redirect:/member/mypage/" + followeeId;
    }

}
