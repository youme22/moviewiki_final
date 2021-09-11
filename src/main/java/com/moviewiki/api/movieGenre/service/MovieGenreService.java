package com.moviewiki.api.movieGenre.service;

import com.moviewiki.api.movieGenre.domain.MovieGenre;

import java.util.List;

public interface MovieGenreService {

    public void save(MovieGenre movieGenre);

    public List<MovieGenre> findById(String genreId);
}
