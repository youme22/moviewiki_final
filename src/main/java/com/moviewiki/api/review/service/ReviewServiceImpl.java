package com.moviewiki.api.review.service;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.like.repository.LikeRepository;
import com.moviewiki.api.prefActor.Service.PrefActorService;
import com.moviewiki.api.prefDirector.service.PrefDirectorService;
import com.moviewiki.api.prefGenre.service.PrefGenreService;
import com.moviewiki.api.prefNation.Service.PrefNationService;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private LikeRepository likeRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, LikeRepository likeRepository) {
        this.reviewRepository = reviewRepository;
        this.likeRepository = likeRepository;
    }


    @Override
    public void doReview(Review review) {
        reviewRepository.saveReview(review); // 리뷰 등록
        PrefGenreService.updatePrefGenre(review); // 장르 선호도 업데이트
        PrefNationService.updatePrefNation(review); // 국가 선호도 업데이트
        PrefDirectorService.updatePrefDirector(review); // 감독 선호도 업데이트
        PrefActorService.updatePrefActor(review); // 배우 테이블 업데이트
    }

    @Override
    public void modifyReview(Review review) {
        reviewRepository.saveReview(review); // 리뷰 수정

    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteByReviewId(reviewId); // 리뷰 삭제
    }

    @Override
    public void likeReview(Like like) {
        likeRepository.saveLike(like);
    }

    @Override
    public void unlikeReview(Like like) {
        likeRepository.deleteLike(like);
    }
}
