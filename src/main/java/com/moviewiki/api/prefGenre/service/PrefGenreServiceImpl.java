package com.moviewiki.api.prefGenre.service;


import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movieGenre.repository.MovieGenreRepository;
import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.repository.PrefGenreRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class PrefGenreServiceImpl implements PrefGenreService {


    private PrefGenreRepository prefGenreRepository;
    private ReviewRepository reviewRepository;
    private MovieGenreRepository movieGenreRepository;
  
    private final EntityManager em;

    public PrefGenreServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public PrefGenreServiceImpl(PrefGenreRepository prefGenreRepository, ReviewRepository reviewRepository, MovieGenreRepository movieGenreRepository, EntityManager em) {

        this.prefGenreRepository = prefGenreRepository;
        this.reviewRepository = reviewRepository;
        this.movieGenreRepository = movieGenreRepository;

        this.em = em;
    }

    @Override
    public void updatePrefGenre(Review review) {

        User user = review.getUser();
        Date genreReviewDate = null; // updatePrefGenre메소드가 호출되는 날짜
        Genre genre = movieGenreRepository.findGenreByMovie(review.getMovie());
//        List<Review> genreReviewList = reviewRepository.findGenreReviewListByUserIdAndGenreId(user.getUserId(), genre.getGenreId());
        List<Review> genreReviewList = reviewRepository.findDirectorReviewListByUser(user); //임시코드 삭제예정
        int genreReviewCount = genreReviewList.size(); // 메소드 아무거나 고름 -> 리뷰 카운트 메소드로 변경 예정
        double genrePoint = genreReviewList.hashCode(); // 메소드 아무거나 고름 -> 선호도 계산 메소드로 변경 예정, 평점(-3)의 총합을 genreReviewCount로 나눈 값
        PrefGenre prefGenre = new PrefGenre(user, genre, genrePoint, genreReviewCount, genreReviewDate); // PrefGenre 생성
//        prefGenreRepository.savePrefGenre(prefGenre); //PrefGenre 테이블에 저장

    }

    // 추천 Test2
    @Override
    public List<PrefGenre> findByUser(User user){
//        List<PrefGenre> prefGenreList =
//                em.createQuery("select pg from PrefGenre pg",PrefGenre.class).getResultList();
//                em.createQuery("select max(pg.genrePoint) from PrefGenre pg where pg.user = 'test1'",PrefGenre.class).getResultList();
        return prefGenreRepository.findByUser(user);
    }


//    @Override
//    public List<MovieGenre> findByGenre(){
//        List<MovieGenre> movieGenreList =
//        return movieGenreList;
//    }

}
