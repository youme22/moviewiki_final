package com.moviewiki.api.prefDirector.service;

import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefDirector.domain.PrefDirector;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;

import java.util.List;

public interface PrefDirectorService {

    void updatePrefDirector(Review review);

    // 민형 - 유저로 선호 감독 리스트
    List<PrefDirector> prefDirectorList(User user);
}
