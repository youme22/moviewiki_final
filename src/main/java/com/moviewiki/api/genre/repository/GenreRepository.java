package com.moviewiki.api.genre.repository;

import com.moviewiki.api.genre.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
