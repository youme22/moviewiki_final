package com.moviewiki.api.prefActor.Service;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefActor.repository.PrefActorRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;

import java.util.Date;

public class PrefActorServiceImpl implements PrefActorService {

    private ReviewRepository reviewRepository;
    private PrefActorRepository prefActorRepository;

    @Override
    public void updatePrefActor(Review review) {
        User user = review.getUser();
        Actor actor = reviewRepository.findActorByReview(review); // 배우가 누군지
        Date actorReviewDate = null; // updatePrefActor메소드가 호출되는 날짜
        int actorReviewCount = 0; //리뷰테이블과 출연작 테이블을 조인한 테이블에 이 유저와 이 배우로 찾아서 갯수 새기
        double actorPoint = 0; // 리뷰테이블과 출연작 테이블을 조인한 테이블에서 이 유저와 이 배우로 찾아서 평점(-3)을 다 더함 리뷰카운트로 나눔
        PrefActor prefActor = new PrefActor(user, actor, actorPoint, actorReviewCount, actorReviewDate); // PrefActor 생성
        prefActorRepository.savePrefActor(prefActor); //PrefActor 테이블에 저장

    }
}
