/*package com.moviewiki.api.recommend.controller;

import com.moviewiki.api.recommend.service.RecommendService;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecommendController {

    @Autowired
    private RecommendService recommendService;
    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping("/main")
    public String recommendByReview(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        String userId = currentUser.getUsername();
        User user = userManagementService.getUser(currentUser.getUsername());
        model.addAttribute("movieListByReviewRecommend",recommendService.recommendByReview(user));
        return "member_template/main";
    }

    @RequestMapping("/main")
    public String recommendByFollowing(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        String userId = currentUser.getUsername();
        User user = userManagementService.getUser(userId);
        model.addAttribute("movieListByFollowingRecommend",recommendService.recommendByFollowing(user));
        return "member_template/main";
    }

}*/

