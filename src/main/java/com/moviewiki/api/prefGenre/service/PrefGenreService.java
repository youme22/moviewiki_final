package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.review.domain.Review;
import org.springframework.stereotype.Service;

@Service
public interface PrefGenreService {

    void updatePrefGenre(Review review);

}
