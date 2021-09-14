package com.moviewiki.api.following.controller;

import com.moviewiki.api.following.domain.Following;
import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.following.service.FollowingService;
import com.moviewiki.api.user.controller.UserManagementController;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import lombok.RequiredArgsConstructor;
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
    public String followingPage(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        User fromUser = userManagementService.getUser(userId);
        List<Following> followeeList = followingService.followeeList(fromUser);
        log.info("followeeList======" + followeeList);
        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("followeeList", followeeList);
        return "/member/followee";
    }

    // 팔로워 리스트 출력, form call
    @RequestMapping("/member/followerList/{userId}")
    public String followerPage(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        User toUser = userManagementService.getUser(userId);
        List<Following> followerList = followingService.followerList(toUser);
        log.info("followerList======" + followerList);
        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("followerList", followerList);
        return "/member/follower";
    }



    /* follow 기능
        fromUserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 추가
        toUserId : 팔로우 당하는 유저의 id
        return  새로 생성된 follow 객체 리턴
     */
//    @RequestMapping("/follow")
//    public String follow(HttpServletRequest request, Model model) throws Exception {
//        String currentUserId = request.getParameter("currentUserId");
//        String pageId = request.getParameter("pageId");
//
//        followingService.save(currentUserId, pageId);
//
//        String url = "redirect:/member/following" + pageId;
//        return url;
//    }


    /* unfollow 기능
        fromuserId를 가진 user가 toUserId를 가진 user를 팔로우 정보를 삭제
        @toUserId : 언팔로우 당하는 유저의 id
     */

}
