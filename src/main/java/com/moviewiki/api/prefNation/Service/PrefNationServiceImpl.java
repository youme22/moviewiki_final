package com.moviewiki.api.prefNation.Service;

import com.moviewiki.api.nation.domain.Nation;
import com.moviewiki.api.prefNation.domain.PrefNation;
import com.moviewiki.api.prefNation.repository.PrefNationRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;

import java.util.Date;

public class PrefNationServiceImpl implements PrefNationService {

    private ReviewRepository reviewRepository;
    private PrefNationRepository prefNationRepository;

    @Override
    public void updatePrefNation(Review review) {
        User user = review.getUser();
        Nation nation = reviewRepository.findNationByReview(review); // 어떤 국가인지
        Date nationReviewDate = null; // updatePrefNation메소드가 호출되는 날짜
        int nationReviewCount = 0; //리뷰테이블과 영화국가 테이블을 조인한 테이블에 이 유저와 이 국가로 찾아서 갯수 새기
        double nationPoint = 0; // 리뷰테이블과 영화국가 테이블을 조인한 테이블에서 이 유저와 이 국가로 찾아서 평점(-3)을 다 더함 리뷰카운트로 나눔
        PrefNation prefNation = new PrefNation(user, nation, nationPoint, nationReviewCount, nationReviewDate); // PrefNation 생성
        prefNationRepository.savePrefNation(prefNation); //PrefNation 테이블에 저장

    }

}
