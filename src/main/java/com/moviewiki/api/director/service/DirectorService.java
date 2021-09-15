package com.moviewiki.api.director.service;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.director.domain.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {

    // 새로운 감독 등록
    public void save(Director director);

    // 특정 감독 찾기 -> 감독코드로
    public Optional<Director> findById(String directorId);

    // 특정 감독 찾기 -> 이름으로
    public List<Director> findByDirectorName(String directorName);

    // 모든 감독
    public List<Director> findAll();
}
