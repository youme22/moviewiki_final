package com.moviewiki.api.movie.service;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movie.domain.MovieForm;
import com.moviewiki.api.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public Movie findByMovieId(Long movieId) {
        return movieRepository.findByMovieId(movieId);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }



    // 입력받는 검색 test
    @Transactional
    public List<MovieForm> searchMovies(String keyword) {
        List<Movie> movies = movieRepository.findByMovieNameContaining(keyword);
        List<MovieForm> searchList = new ArrayList<>();

        if (movies.isEmpty()) return searchList;

        for (Movie movie : movies) {
            searchList.add(this.convertEntityToDto(movie));
        }

        return searchList;
    }

    private MovieForm convertEntityToDto(Movie movie) {
        return MovieForm.builder()
                .movieName(movie.getMovieName())
                .movieOgName(movie.getMovieOgName())
                .movieProfile(movie.getMovieProfile())
                .filmRating(movie.getFilmRating())
                .build();
    }
}
