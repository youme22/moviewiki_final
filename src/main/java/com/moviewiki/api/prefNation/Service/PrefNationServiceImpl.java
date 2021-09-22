package com.moviewiki.api.prefNation.Service;

import com.moviewiki.api.movieNation.repository.MovieNationRepository;
import com.moviewiki.api.nation.domain.Nation;
import com.moviewiki.api.prefNation.domain.PrefNation;
import com.moviewiki.api.prefNation.repository.PrefNationRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PrefNationServiceImpl implements PrefNationService {

    private ReviewRepository reviewRepository;
    private PrefNationRepository prefNationRepository;
    private MovieNationRepository movieNationRepository;

    @Autowired
    public PrefNationServiceImpl(ReviewRepository reviewRepository, PrefNationRepository prefNationRepository, MovieNationRepository movieNationRepository) {

        this.reviewRepository = reviewRepository;
        this.prefNationRepository = prefNationRepository;
        this.movieNationRepository = movieNationRepository;

    }

    @Override
    public void updatePrefNation(Review review) {

        User user = review.getUser();
        Date nationReviewDate = null; // updatePrefNation메소드가 호출되는 날짜
        Nation nation = movieNationRepository.findNationByMovie(review.getMovie());
//        List<Review> nationReviewList = reviewRepository.findNationReviewListByUserIdAndNationId(user.getUserId(), nation.getNationId());
        List<Review> nationReviewList = reviewRepository.findActorReviewListByUser(user); //임시코드삭제예정
        int nationReviewCount = nationReviewList.size(); // 메소드 아무거나 고름 -> 리뷰 카운트 메소드로 변경 예정
        double nationPoint = nationReviewList.hashCode(); // 메소드 아무거나 고름 -> 선호도 계산 메소드로 변경 예정, 평점(-3)의 총합을 nationReviewCount로 나눈 값
        PrefNation prefNation = new PrefNation(user, nation, nationPoint, nationReviewCount, nationReviewDate); // PrefNation 생성
//        prefNationRepository.savePrefNation(prefNation); //PrefNation 테이블에 저장

    }

    // 민형 - 유저로 선호 국가 리스트
    @Override
    public List<PrefNation> prefNationList(User user) {
        return prefNationRepository.findByUser(user);
    }
}
