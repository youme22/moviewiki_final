package com.moviewiki.api.movie.service;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
