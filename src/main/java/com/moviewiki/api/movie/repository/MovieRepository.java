package com.moviewiki.api.movie.repository;

import com.moviewiki.api.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByMovieId(Long movieId);

    // 선호 장르 영화 추천
    public List<Movie> findAll();
}

