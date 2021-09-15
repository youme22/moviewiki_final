package com.moviewiki.api.movie.service;

import com.moviewiki.api.movie.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    // 새로운 영화 저장 및 update
    public void save(Movie movie);

    // 특정 영화 찾기
    public Optional<Movie> findById(Long movieId);
    /* 사용금지(임시용) -> 위에꺼 사용*/
    public Movie findByMovieId(Long movieId);


    // 모든 영화
    public List<Movie> findAll();
}
