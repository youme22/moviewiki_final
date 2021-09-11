package com.moviewiki.api.review.service;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.review.domain.Review;

public interface ReviewService {

    void doReview(Review review);
    void modifyReview(Review review);
    void deleteReview(String reviewId);
    void likeReview(Like like);
    void unlikeReview(Like like);
}
