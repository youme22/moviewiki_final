package com.moviewiki.api.review.controller;

import com.moviewiki.api.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewContoller {

    private ReviewService reviewService;

    @Autowired
    public ReviewContoller(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
