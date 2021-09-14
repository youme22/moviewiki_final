package com.moviewiki.api.review.service;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.like.repository.LikeRepository;
import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefActor.repository.PrefActorRepository;
import com.moviewiki.api.prefDirector.domain.PrefDirector;
import com.moviewiki.api.prefDirector.repository.PrefDirectorRepository;
import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.repository.PrefGenreRepository;
import com.moviewiki.api.prefNation.domain.PrefNation;
import com.moviewiki.api.prefNation.repository.PrefNationRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private LikeRepository likeRepository;
    private PrefGenreRepository prefGenreRepository;
    private PrefNationRepository prefNationRepository;
    private PrefDirectorRepository prefDirectorRepository;
    private PrefActorRepository prefActorRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, LikeRepository likeRepository, PrefGenreRepository prefGenreRepository, PrefNationRepository prefNationRepository, PrefDirectorRepository prefDirectorRepository, PrefActorRepository prefActorRepository) {
        this.reviewRepository = reviewRepository;
        this.likeRepository = likeRepository;
        this.prefGenreRepository = prefGenreRepository;
        this.prefNationRepository = prefNationRepository;
        this.prefDirectorRepository = prefDirectorRepository;
        this.prefActorRepository = prefActorRepository;
    }


    @Override
    public void doReview(Review review) {
        reviewRepository.saveReview(review); // 리뷰 등록
        prefGenreService.updatePrefGenre(prefGenre); // 장르 선호도 업데이트
        prefNationService.savePrefNation(prefNation); // 국가 선호도 업데이트
        prefDirectorService.savePrefDirector(prefDirector); // 감독 선호도 업데이트
        prefActorService.savePrefActor(prefActor); // 배우 테이블 업데이트
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
