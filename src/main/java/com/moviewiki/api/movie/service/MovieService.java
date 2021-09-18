package com.moviewiki.api.movie.service;

import com.moviewiki.api.movie.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    // 새로운 영화 저장 및 update
    void save(Movie movie);

    // 특정 영화 조회
    Optional<Movie> findById(Long movieId);

    // 특정 영화 조회
    Movie findByMovieId(Long movieId);

    // 모든 영화
    List<Movie> findAll();

}
