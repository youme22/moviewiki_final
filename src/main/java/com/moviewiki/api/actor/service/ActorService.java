package com.moviewiki.api.actor.service;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.movie.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ActorService {

    // 새로운 배우 등록
    public void save(Actor actor);

    // 특정 배우 찾기 -> 배우코드로
    public Optional<Actor> findById(Long actorId);

    // 특정 배우 찾기 -> 이름으로
    public List<Actor> findByActorName(String actorName);

    // 모든 영화
    public List<Actor> findAll();
}
