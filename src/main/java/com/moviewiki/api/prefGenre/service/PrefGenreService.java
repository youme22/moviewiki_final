package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrefGenreService {
    public List<PrefGenre> findAll();

}
