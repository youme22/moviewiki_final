package com.moviewiki.api.movieNation.repository;

import com.moviewiki.api.movieNation.domain.MovieNation;
import com.moviewiki.api.nation.domain.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieNationRepository extends JpaRepository<MovieNation, Nation> {
}
