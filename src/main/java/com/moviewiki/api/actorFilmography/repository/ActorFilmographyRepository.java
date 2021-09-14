package com.moviewiki.api.actorFilmography.repository;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.actorFilmography.domain.ActorFilmography;
import com.moviewiki.api.actorFilmography.domain.ActorFilmographyPK;
import com.moviewiki.api.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorFilmographyRepository extends JpaRepository<ActorFilmography, ActorFilmographyPK> {

    List<ActorFilmography> findActorFilmographyByActor(Actor actor);
    Actor findActorByMovie(Movie movie); // 선호도 업데이트 시 필요 - 효미

}