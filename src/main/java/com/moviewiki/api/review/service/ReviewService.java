package com.moviewiki.api.review.service;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;

import javax.transaction.Transactional;
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
    List<Review> getReviewListByUser(User user);

    // 민형 - 내가 리뷰한 영화 감상 시간
    int myRunningtime(List<Review> reviewList);

    // 민형 - 리뷰 삭제
    void removeReview(Long reviewId);

    // 리뷰 조회
    Review getReview(Long reviewId);
}
