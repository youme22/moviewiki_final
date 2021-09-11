package com.moviewiki.api.actor.repository;

import com.moviewiki.api.actor.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    public List<Actor> findByActorName(String actorName);
}