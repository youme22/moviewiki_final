package com.moviewiki.api.prefActor.Service;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.actorFilmography.repository.ActorFilmographyRepository;
import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefActor.repository.PrefActorRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PrefActorServiceImpl implements PrefActorService {

    private ReviewRepository reviewRepository;
    private PrefActorRepository prefActorRepository;
    private ActorFilmographyRepository actorFilmographyRepository;

    @Autowired
    public PrefActorServiceImpl(ReviewRepository reviewRepository, PrefActorRepository prefActorRepository, ActorFilmographyRepository actorFilmographyRepository) {

        this.reviewRepository = reviewRepository;
        this.prefActorRepository = prefActorRepository;
        this.actorFilmographyRepository = actorFilmographyRepository;

    }

    @Override
    public void updatePrefActor(Review review) {

        User user = review.getUser();
        Date actorReviewDate = null; // updatePrefActor메소드가 호출되는 날짜
        Actor actor = actorFilmographyRepository.findActorByMovie(review.getMovie());
//        List<Review> actorReviewList = reviewRepository.findActorReviewListByUserIdAndActorId(user.getUserId(), actor.getActorId());
        List<Review> actorReviewList = reviewRepository.findGenreReviewListByUser(user); //임시코드 삭제예정
        int actorReviewCount = actorReviewList.size(); // 메소드 아무거나 고름 -> 리뷰 카운트 메소드로 변경 예정
        double actorPoint = actorReviewList.hashCode(); // 메소드 아무거나 고름 -> 선호도 계산 메소드로 변경 예정, 평점(-3)의 총합을 actorReviewCount로 나눈 값
        PrefActor prefActor = new PrefActor(user, actor, actorPoint, actorReviewCount, actorReviewDate); // PrefActor 생성
//        prefActorRepository.savePrefActor(prefActor); //PrefActor 테이블에 저장

    }

}
