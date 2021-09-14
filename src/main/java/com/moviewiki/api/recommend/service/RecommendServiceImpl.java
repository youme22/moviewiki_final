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
    public List<Movie> recommendByReview(String userId) {

        List<Movie> highRatedMovieList1 = reviewRepository.findHighRatedMovieByUserId(userId);
        List<User> highRatingUserList = reviewRepository.findHighRatingUserByMovieList(highRatedMovieList1);
        List<Movie> highRatedMovieList2 = reviewRepository.findHighRatedMovieByUserList(highRatingUserList);
        List<Movie> movieListByReviewRecommending = highRatedMovieList2;//를 어케어케 해서
        return movieListByReviewRecommending;

    }

    @Override
    public List<Movie> recommendByFollowing(String userId) {

        List<User> followeeList = followingRepository.findFolloweeByFollowerId(userId);
        List<Movie> highRatedMovieList = reviewRepository.findHighRatedMovieByUserList(followeeList);
        List<Movie> movieListByFollowingRecommending = highRatedMovieList;//를 어케어케 해서
        return movieListByFollowingRecommending;

    }

}