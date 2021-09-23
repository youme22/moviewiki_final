package com.moviewiki.api.movieNation.repository;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movieNation.domain.MovieNation;
import com.moviewiki.api.movieNation.domain.MovieNationPK;
import com.moviewiki.api.nation.domain.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieNationRepository extends JpaRepository<MovieNation, MovieNationPK> {

    List<MovieNation> findMovieNationByNation(Nation nation);
    Nation findNationByMovie(Movie movie); // 선호도 업데이트 시 필요 - 효미

}
