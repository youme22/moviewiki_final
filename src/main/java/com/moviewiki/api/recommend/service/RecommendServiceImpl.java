package com.moviewiki.api.recommend.service;


import com.moviewiki.api.following.repository.FollowingRepository;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.review.repository.ReviewRepository;
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
        return null;
    }

    @Override
    public List<Movie> recommendByFollowing(String userId) {
        return null;
    }
}
