package com.moviewiki.api.movieGenre.repository;

import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movieGenre.domain.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepository extends JpaRepository<MovieGenre, Genre> {
}
