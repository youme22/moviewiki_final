package com.moviewiki.api.user.controller;

import com.moviewiki.api.following.service.FollowingService;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.service.ReviewService;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import com.moviewiki.api.wantToSee.domain.WantToSee;
import com.moviewiki.api.wantToSee.service.WantToSeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MypageProcessController {
    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    FollowingService followingService;

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    WantToSeeService wantToSeeService;

    @Autowired
    ReviewService reviewService;

    // 마이페이지 form call
    @GetMapping("/member/mypage/{userId}")
    public String mypageMain(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        User loginUser = userManagementService.getUser(currentUser.getUsername());
        User pageUser = userManagementService.getUser(userId);

        model.addAttribute("countReview", reviewService.countReviews(pageUser));
        model.addAttribute("countWantToSee", wantToSeeService.countWantToSee(pageUser));
        model.addAttribute("countFollower", followingService.countFollower(pageUser));
        model.addAttribute("countFollowee", followingService.countFollowee(pageUser));
        model.addAttribute("isFollowing", followingService.isFollowing(loginUser, pageUser));
        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("user", userManagementService.getUser(userId));
        return "member/mypage";
    }


    // 취향분석 페이지 form call
    @RequestMapping("/member/pref/{userId}")
    public String prefPage(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        User pageUser = userManagementService.getUser(userId);
        List<Review> reviewList = reviewService.getReviewListByUser(pageUser);

        model.addAttribute("myRunningTime", reviewService.myRunningtime(reviewList));
        model.addAttribute("countReview", reviewService.countReviews(pageUser));
        model.addAttribute("currentUserId", currentUser.getUsername());
        return "/member/pref";
    }

    // 시청한 영화 페이지 form call
    @RequestMapping("/member/reviews/{userId}")
    public String reviewsPage(@PathVariable String userId, Model model, Authentication auth) {
        User pageUser = userManagementService.getUser(userId);
        List<Review> reviewList = reviewService.getReviewListByUser(pageUser);

//        model.addAttribute("countLike", likeService.countLikes()
        model.addAttribute("currentUserId", auth.getName());
        model.addAttribute("reviewList", reviewList);
        return "/member/reviews";
    }

    // 관심 영화 페이지 form call
    @RequestMapping("/member/want_to_see/{userId}")

    public String wantToSeePage(@PathVariable String userId, Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {

        User pageUser = userManagementService.getUser(userId);
        List<WantToSee> wantToSeeList = wantToSeeService.findByUser(pageUser);

        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("wantToSeeList", wantToSeeList);

        return "/member/want_to_see";
    }

    // 리뷰 삭제
    @RequestMapping("/deleteReview/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId, HttpServletRequest request) {
        String pageId = request.getParameter("userId");
        reviewService.removeReview(reviewId);

        return "redirect:/member/reviews/" + pageId;
    }

    // 리뷰 수정
    @PostMapping("/updateReview/{reviewId}")
    public String updateUser(@PathVariable Long reviewId, Review updateReview, Authentication auth) {
        String loginId = auth.getName();
        // 리뷰 가져오기
        Review review = reviewService.getReview(reviewId);

        // 원래 있던 유저값에 세팅
        review.setComment(updateReview.getComment());
        review.setRatingPoint(updateReview.getRatingPoint());

        reviewService.modifyReview(review);
        return "redirect:/member/reviews/" + loginId;
    }
}
