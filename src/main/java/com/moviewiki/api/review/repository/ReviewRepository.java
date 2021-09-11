package com.moviewiki.api.review.repository;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    void addReview(Review review);
    List<Movie> findHighRatedMovieByUserId(String userId);
    List<User> findHighRatingUserByMovieList(List<Movie> movieList);
    List<Movie> findHighRatedMovieByUserList(List<User> userList);
    String findGenreIdByReviewIdAndMovieId(String reviewId, String movieId);
    String findNationIdByReviewIdAndMovieId(String reviewId, String movieId);
    String findDirectorIdByReviewIdAndMovieId(String reviewId, String movieId);
    String findActorIdByReviewIdAndMovieId(String reviewId, String movieId);
    void updateReview(Review review);
    void deleteReview(String reviewId);
}
