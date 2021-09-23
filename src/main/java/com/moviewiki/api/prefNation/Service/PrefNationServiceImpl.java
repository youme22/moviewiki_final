package com.moviewiki.api.prefNation.Service;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movieNation.repository.MovieNationRepository;
import com.moviewiki.api.nation.domain.Nation;
import com.moviewiki.api.prefNation.domain.PrefNation;
import com.moviewiki.api.prefNation.repository.PrefNationRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class PrefNationServiceImpl implements PrefNationService {

    private ReviewRepository reviewRepository;
    private PrefNationRepository prefNationRepository;
    private MovieNationRepository movieNationRepository;

    private final EntityManager em;

    public PrefNationServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public PrefNationServiceImpl(ReviewRepository reviewRepository, PrefNationRepository prefNationRepository, MovieNationRepository movieNationRepository,EntityManager em) {

        this.reviewRepository = reviewRepository;
        this.prefNationRepository = prefNationRepository;
        this.movieNationRepository = movieNationRepository;
        this.em = em;
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

    // 선호 국가 영화 추천
    @Override
    public List<Movie> findAll(){
        String sql = "SELECT * FROM MOVIES\n" +
                "WHERE MOVIE_ID IN(\n" +
                "                SELECT MOVIE_ID FROM MOVIE_NATION\n" +
                "                WHERE NATION_ID IN\n" +
                "                (SELECT NATION_ID from PREF_NATIONS where NATION_POINT =\n" +
                "                (select max(NATION_POINT) from PREF_NATIONS where USER_ID = 'veddy0')))";
        List<Movie> recNationList = em.createNativeQuery(sql, Movie.class).getResultList();
        return recNationList.subList(0, 12);

    }
}
