package com.moviewiki.api.recommend.service;

import com.moviewiki.api.movie.domain.Movie;

import java.util.List;

public interface RecommendService {
    List<Movie> recommendByReview(String userId);
    List<Movie> recommendByFollowing(String userId);
}
