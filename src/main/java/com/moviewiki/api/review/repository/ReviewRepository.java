package com.moviewiki.api.review.repository;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.nation.domain.Nation;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

     // 리뷰 기반, 팔로우 기반 추천에서 쓰이는 메소드
     // 이 유저가 5점 준 Review 리스트
     @Query("select Review from Review where user = :user and reviewRating = 5")
     List<Review> findHighRatingReviewListByUser(@Param("user") User user);
     // 이 영화에 5점 준 Review 리스트
     @Query("select Review from Review where movie = :movie and reviewRating = 5")
     List<Review> findHighRatingReviewListByMovie(@Param("movie") Movie movie);


     // REVIEWS X MOVIE_GENRES movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 장르 영화에 대한 리뷰리스트 반환
     @Query("select Review from Review, MovieGenre where Review.movie.movieId = MovieGenre.movie.movieId and Review.user = :user and MovieGenre.genre = :genre")
     List<Review> findGenreReviewListByUserAndGenre(@Param("user") User user, @Param("genre") Genre genre);
     // REVIEWS X MOVIE_NATIONS movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 국가 영화에 대한 리뷰리스트 반환
     @Query("select Review from Review, MovieNation where Review.movie.movieId = MovieNation.movie.movieId and Review.user = :user and MovieNation.nation = :nation")
     List<Review> findNationReviewListByUserAndNation(@Param("user") User user, @Param("nation") Nation nation);
     // REVIEWS X DIRECTOR_FILMOGRAPHY movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 감독 영화에 대한 리뷰리스트 반환
     @Query("select Review from Review, DirectorFilmography where Review.movie.movieId = DirectorFilmography.movie.movieId and Review.user = :user and DirectorFilmography.director = :director")
     List<Review> findDirectorReviewListByUserAndDirector(@Param("user") User user, @Param("director") Director director);
     // REVIEWS X ACTOR_FILMOGRAPHY movieId 기준으로 조인한 테이블에서 -> 이 유저의 이 배우 영화에 대한 리뷰리스트 반환
     @Query("select Review from Review, ActorFilmography where Review.movie.movieId = ActorFilmography.movie.movieId and Review.user = :user and ActorFilmography.actor = :actor")
     List<Review> findActorReviewListByUserAndActor(@Param("user") User user, @Param("actor") Actor actor);


     // 민형, 효미 - 리뷰 등록 or 수정
//     void save(Review review);

     // 민형, 효미 - 리뷰 삭제
     void deleteByReviewId(Long reviewId);

     // 민형 - 리뷰 수
     int countReviewByUser(User user);

     // 민형 - 사용자 기준으로 리뷰 조회
     List<Review> findByUser(User user);

     // 민형 - 리뷰 조회
     Review findByReviewId(Long reviewId);
}