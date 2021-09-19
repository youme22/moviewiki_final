package com.moviewiki.api.review.controller;

import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 민형 - 리뷰 삭제
    @RequestMapping("/deleteReview/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId, HttpServletRequest request) {
        String pageId = request.getParameter("userId");
        reviewService.removeReview(reviewId);

        return "redirect:/member/reviews/" + pageId;
    }

    // 민형 - 리뷰 수정
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