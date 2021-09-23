package com.moviewiki.api.prefNation.Service;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.review.domain.Review;

import java.util.List;

public interface PrefNationService {

    void updatePrefNation(Review review);

    // 선호 국가 영화 추천
    public List<Movie> findAll();
}
