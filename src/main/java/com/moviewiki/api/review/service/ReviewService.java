package com.moviewiki.api.review.service;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;

import java.util.List;

public interface ReviewService {

    void doReview(Review review);
    void modifyReview(Review review);
    void deleteReview(Review review);
    void likeReview(Like like);
    void unlikeReview(Like like);


    // 민형 - 리뷰 수
    int countReviews(User user);

    // 민형 - 사용자 기준으로 리뷰 조회
    List<Review> getReviews(User user);
}
