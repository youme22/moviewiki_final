package com.moviewiki.api.prefNation.Service;

import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefNation.domain.PrefNation;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;

import java.util.List;

public interface PrefNationService {

    void updatePrefNation(Review review);

    // 민형 - 유저로 선호 국가 리스트
    List<PrefNation> prefNationList(User user);
}
