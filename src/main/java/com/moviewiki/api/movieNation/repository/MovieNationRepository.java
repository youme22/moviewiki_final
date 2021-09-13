package com.moviewiki.api.movieNation.repository;

import com.moviewiki.api.movieNation.domain.MovieNation;
import com.moviewiki.api.nation.domain.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieNationRepository extends JpaRepository<MovieNation, Long> {
    public List<MovieNation> findMovieNationByNation(Nation nation);
}
