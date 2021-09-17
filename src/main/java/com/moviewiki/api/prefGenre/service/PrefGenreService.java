package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.review.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrefGenreService {

    void updatePrefGenre(Review review);

    // 선호 장르 영화 추천
    public List<Movie> findAll();

}
