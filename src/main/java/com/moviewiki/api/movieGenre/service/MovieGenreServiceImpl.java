package com.moviewiki.api.movieGenre.service;

import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movieGenre.domain.MovieGenre;
import com.moviewiki.api.movieGenre.repository.MovieGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreServiceImpl implements MovieGenreService{

    @Autowired
    private MovieGenreRepository movieGenreRepository;

    // Genre
    @Override
    public List<MovieGenre> findMovieGenreByGenre(Genre genre){
        return movieGenreRepository.findMovieGenreByGenre(genre);
    }

    // Movie
    @Override
    public List<MovieGenre> findMovieGenreByMovie(Movie movie){
        return movieGenreRepository.findMovieGenreByMovie(movie);
    }

}
