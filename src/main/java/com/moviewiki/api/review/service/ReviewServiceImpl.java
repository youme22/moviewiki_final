package com.moviewiki.api.review.service;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.like.repository.LikeRepository;
import com.moviewiki.api.prefActor.Service.PrefActorService;
import com.moviewiki.api.prefDirector.service.PrefDirectorService;
import com.moviewiki.api.prefGenre.service.PrefGenreService;
import com.moviewiki.api.prefNation.Service.PrefNationService;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private LikeRepository likeRepository;
    private PrefGenreService prefGenreService;
    private PrefNationService prefNationService;
    private PrefDirectorService prefDirectorService;
    private PrefActorService prefActorService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, LikeRepository likeRepository, PrefGenreService prefGenreService, PrefNationService prefNationService, PrefDirectorService prefDirectorService, PrefActorService prefActorService) {

        this.reviewRepository = reviewRepository;
        this.likeRepository = likeRepository;
        this.prefGenreService = prefGenreService;
        this.prefNationService = prefNationService;
        this.prefDirectorService = prefDirectorService;
        this.prefActorService = prefActorService;

    }

    @Override
    public void doReview(Review review) {

//        reviewRepository.saveReview(review); // 리뷰 등록
        prefGenreService.updatePrefGenre(review); // 장르 선호도 업데이트
        prefNationService.updatePrefNation(review); // 국가 선호도 업데이트
        prefDirectorService.updatePrefDirector(review); // 감독 선호도 업데이트
        prefActorService.updatePrefActor(review); // 배우 테이블 업데이트

    }

// doReview()랑 modifyReview() 합쳐도 되는지 고민

    @Override
    public void modifyReview(Review review) {

//        reviewRepository.saveReview(review); // 리뷰 수정
        prefGenreService.updatePrefGenre(review); // 장르 선호도 업데이트
        prefNationService.updatePrefNation(review); // 국가 선호도 업데이트
        prefDirectorService.updatePrefDirector(review); // 감독 선호도 업데이트
        prefActorService.updatePrefActor(review); // 배우 테이블 업데이트

    }

    @Override
    public void deleteReview(Review review) {

//        reviewRepository.deleteReview(review); // 리뷰 삭제
        prefGenreService.updatePrefGenre(review); // 장르 선호도 업데이트
        prefNationService.updatePrefNation(review); // 국가 선호도 업데이트
        prefDirectorService.updatePrefDirector(review); // 감독 선호도 업데이트
        prefActorService.updatePrefActor(review); // 배우 테이블 업데이트

    }

    @Override
    public void likeReview(Like like) {

//        likeRepository.saveLike(like);

    }

    @Override
    public void unlikeReview(Like like) {

//        likeRepository.deleteLike(like);

    }

    // 민형 - 리뷰 수
    @Override
    public int countReviews(User user) {
        return reviewRepository.countReviewByUser(user);
    }

    // 민형 - 사용자 기준으로 리뷰 조회
    @Override
    public List<Review> getReview(User user) {
        return reviewRepository.findByUser(user);
    }
}
