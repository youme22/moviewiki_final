package com.moviewiki.api.review.repository;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

     // 리뷰 기반, 팔로우 기반 추천에서 쓰이는 메소드
     List<Movie> findHighRatedMovieByUserId(String userId);
     List<User> findHighRatingUserByMovieList(List<Movie> movieList);
     List<Movie> findHighRatedMovieByUserList(List<User> userList);

     // 리뷰 등록시 선호도 점수 업데이트에 필요한 메소드
     String findGenreIdByReview(Review review);
     String findNationIdByReview(Review review);
     Long findDirectorIdByReview(Review review);
     Long findActorIdByReview(Review review);

     // 리뷰 등록, 수정, 삭제
     void saveReview(Review review);
     void deleteByReviewId(Long reviewId);

}