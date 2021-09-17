package com.moviewiki.api.movieGenre.repository;

import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movieGenre.domain.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, Long> {

    List<MovieGenre> findMovieGenreByGenre(Genre genre);
    List<MovieGenre> findMovieGenreByMovie(Movie movie);
    Genre findGenreByMovie(Movie movie); // 선호도 업데이트 시 필요 - 효미

}
