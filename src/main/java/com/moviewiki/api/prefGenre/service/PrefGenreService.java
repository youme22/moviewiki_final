package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.review.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrefGenreService {

    void updatePrefGenre(Review review);
    public List<PrefGenre> findAll();

}
