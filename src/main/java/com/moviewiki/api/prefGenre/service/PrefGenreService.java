package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrefGenreService {

    void updatePrefGenre(Review review);

    // 추천 Test2
    public List<PrefGenre> findByUser(User user);

//    public List<MovieGenre> findByGenre();
}
