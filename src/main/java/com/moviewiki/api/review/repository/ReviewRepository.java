package com.moviewiki.api.review.repository;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.nation.domain.Nation;
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
     // REVIEWS X MOVIE_GENRES movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 장르 영화에 대한 리뷰리스트 반환
     List<Review> findGenreReviewListByUserIdAndGenreId(String userId, String genreId);
     // REVIEWS X MOVIE_NATIONS movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 국가 영화에 대한 리뷰리스트 반환
     List<Review> findNationReviewListByUserIdAndNationId(String userId, String nationId);
     // REVIEWS X DIRECTOR_FILMOGRAPHY movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 감독 영화에 대한 리뷰리스트 반환
     List<Review> findDirectorReviewListByUserIdAndDirectorId(String userId, Long directorId);
     // REVIEWS X ACTOR_FILMOGRAPHY movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 배우 영화에 대한 리뷰리스트 반환
     List<Review> findActorReviewListByUserIdAndActorId(String userId, Long actorId);

     // 리뷰 등록, 수정, 삭제
     void saveReview(Review review);
     void deleteByReviewId(Review review);

}