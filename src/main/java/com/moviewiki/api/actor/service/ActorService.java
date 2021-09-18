package com.moviewiki.api.actor.service;

import com.moviewiki.api.actor.domain.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    // 새로운 배우 등록
    void save(Actor actor);

    // 특정 배우 찾기 -> 배우코드로
    Optional<Actor> findById(Long actorId);

    // 특정 배우 찾기 -> 이름으로
    List<Actor> findByActorName(String actorName);

    // 모든 배우
    List<Actor> findAll();

}