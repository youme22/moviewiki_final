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

        // 5점 준 영화들 중에 랜덤으로 10개 List에 담기
        // 5점 준 영화가 없으면..? -> 4.5점 -> 4점.. (4점 이상 준 영화가 1개도 없으면 이 추천방식은 불가)
        // highRatedMovieList1는 1~10개
        List<Movie> highRatedMovieList1 = reviewRepository.findHighRatedMovieByUser(user);

        // highRatedMovieList1의 영화 각각에 대해 5점 준 유저들 중에
        // 20명 초과 시 랜덤으로 20명을 List에 담기
        // 20명 이하는 다 담기(1명도 없으면 이 추천방식은 불가)
        // highRatingUserList는 1~20개
        Movie highRatedMovie = null; // 일단 임시로 null;
        List<User> highRatingUserList = reviewRepository.findHighRatingUserByMovie(highRatedMovie);

        // highRatingUserList의 유저 각각에 대해 5점 준 영화들 중에
        // 30개 초과 시 랜덤으로 30개를 List에 담기
        // 30개 이하는 다 담기(5개보다 적으면 이 추천방식은 불가)
        // highRatedMovieList2는 5~30개
        User highRatingUser = null; // 일단 임시로 null;
        List<Movie> highRatedMovieList2 = reviewRepository.findHighRatedMovieByUser(highRatingUser);

        List<Movie> movieListByReviewRecommending = highRatedMovieList2;//를 어케어케 해서
        return movieListByReviewRecommending;

    }

    @Override
    public List<Movie> recommendByFollowing(User user) {

        // 팔로이 중 랜덤으로 20명 List에 담기
        // 팔로이가 20명 이하일 시 다 담기(팔로이가 1명도 없으면 이 추천방식은 불가함)
        // followeeList는 1~20개
//      List<User> followeeList = followingRepository.findFolloweeByFollower(user);

        // followeeList의 유저 각각에 대해 5점 준 영화들 중에
        // 30개 초과 시 랜덤으로 30개를 List에 담기
        // 30개 이하는 다 담기(5개보다 적으면 이 추천방식은 불가)
        // highRatedMovieList는 5~30개
        User followee = null; // 오류 안나게 임시로 null
        List<Movie> highRatedMovieList = reviewRepository.findHighRatedMovieByUser(followee);

        List<Movie> movieListByFollowingRecommending = highRatedMovieList;//를 어케어케 해서
        return movieListByFollowingRecommending;

    }

}