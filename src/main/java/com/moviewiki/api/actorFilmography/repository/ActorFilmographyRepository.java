package com.moviewiki.api.actorFilmography.repository;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.actorFilmography.domain.ActorFilmography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorFilmographyRepository extends JpaRepository<ActorFilmography, Long> {

    public List<ActorFilmography> findActorFilmographyByActor(Actor actor);
}