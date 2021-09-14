package com.moviewiki.api.prefDirector.service;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.prefDirector.domain.PrefDirector;
import com.moviewiki.api.prefDirector.repository.PrefDirectorRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;

import java.util.Date;

public class PrefDirectorServiceImpl implements PrefDirectorService {
    private ReviewRepository reviewRepository;
    private PrefDirectorRepository prefDirectorRepository;

    @Override
    public void updatePrefDirector(Review review) {
        User user = review.getUser();
        Director director = reviewRepository.findDirectorByReview(review); // 감독이 누군지
        Date directorReviewDate = null; // updatePrefDirector메소드가 호출되는 날짜
        int directorReviewCount = 0; //리뷰테이블과 연출작 테이블을 조인한 테이블에 이 유저와 이 감독으로 찾아서 갯수 새기
        double directorPoint = 0; // 리뷰테이블과 연출작 테이블을 조인한 테이블에서 이 유저와 이 감독으로 찾아서 평점(-3)을 다 더함 리뷰카운트로 나눔
        PrefDirector prefDirector = new PrefDirector(user, director, directorPoint, directorReviewCount, directorReviewDate); // PrefDirector 생성
        prefDirectorRepository.savePrefDirector(prefDirector); //PrefDirector 테이블에 저장

    }
}
