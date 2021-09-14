package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.repository.PrefGenreRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;

import java.util.Date;

public class PrefGenreServiceImpl implements PrefGenreService {

    private PrefGenreRepository prefGenreRepository;
    private ReviewRepository reviewRepository;

    @Override
    public void updatePrefGenre(Review review) {

        User user = review.getUser();
        Genre genre = reviewRepository.findGenreByReview(review); // 어떤 장르인지
        Date genreReviewDate = null; // updatePrefGenre메소드가 호출되는 날짜
        int genreReviewCount = 0; //리뷰테이블과 영화장르 테이블을 조인한 테이블에 이 유저와 이 장르로 찾아서 갯수 새기
        double genrePoint = 0; // 리뷰테이블과 영화장르 테이블을 조인한 테이블에서 이 유저와 이 장르로 찾아서 평점(-3)을 다 더함 리뷰카운트로 나눔
        PrefGenre prefGenre = new PrefGenre(user, genre, genrePoint, genreReviewCount, genreReviewDate); // PrefGenre 생성
        prefGenreRepository.savePrefGenre(prefGenre); //PrefGenre 테이블에 저장

    }

}
