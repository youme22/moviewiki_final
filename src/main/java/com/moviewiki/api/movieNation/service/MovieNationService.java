package com.moviewiki.api.movieNation.service;

import com.moviewiki.api.movieNation.domain.MovieNation;

import java.util.List;

public interface MovieNationService {

    public void save(MovieNation movieNation);

    public List<MovieNation> findById(String nationId);
}
