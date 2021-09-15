package com.moviewiki.api.recommend.service;

import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    private ReviewRepository reviewRepository;
    private FollowingRepository followingRepository;

    @Autowired
    public RecommendServiceImpl(ReviewRepository reviewRepository, FollowingRepository followingRepository) {

        this.reviewRepository = reviewRepository;
        this.followingRepository = followingRepository;

    }

    @Override
    public List<Movie> recommendByReview(User user) {

        //4점 이상 준 영화 List에 담기(5점 우선)
        List<Movie> highRatedMovieList1 = reviewRepository.findHighRatedMovieByUser(user);

        // highRatedMovieList1의 영화 각각에 대해 5점 준 유저 List에 담기
        Movie highRatedMovie = null; // 일단 임시로 null;
        List<User> highRatingUserList = reviewRepository.findHighRatingUserByMovie(highRatedMovie);

        // highRatingUserList의 유저 각각에 대해 5점 준 영화 List에 담기
        User highRatingUser = null; // 일단 임시로 null;
        List<Movie> highRatedMovieList2 = reviewRepository.findHighRatedMovieByUser(highRatingUser);

        List<Movie> movieListByReviewRecommending = highRatedMovieList2;//를 어케어케 해서
        return movieListByReviewRecommending;

    }

    @Override
    public List<Movie> recommendByFollowing(User user) {

        // 팔로이 중 10명 List에 담기
//      List<User> followeeList = followingRepository.findFolloweeByFollower(user);

        //followeeList의 유저 각각에 대해 5점 준 영화 List에 담기
        User followee = null; // 오류 안나게 임시로 null
        List<Movie> highRatedMovieList = reviewRepository.findHighRatedMovieByUser(followee);

        List<Movie> movieListByFollowingRecommending = highRatedMovieList;//를 어케어케 해서
        return movieListByFollowingRecommending;

    }

}