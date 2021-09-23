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

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PrefActorRepository prefActorRepository;
    @Autowired
    private ActorFilmographyRepository actorFilmographyRepository;

//    @Autowired
//    public PrefActorServiceImpl(ReviewRepository reviewRepository, PrefActorRepository prefActorRepository, ActorFilmographyRepository actorFilmographyRepository) {
//        this.reviewRepository = reviewRepository;
//        this.prefActorRepository = prefActorRepository;
//        this.actorFilmographyRepository = actorFilmographyRepository;
//    }

    // 효미 - 배우 선호도 업데이트
    @Override
    public void updatePrefActor(Review review) {
        User user = review.getUser();
        Date actorReviewDate = new Date();
        Actor actor = actorFilmographyRepository.findActorByMovie(review.getMovie());
        List<Review> actorReviewList = reviewRepository.findActorReviewListByUserAndActor(user, actor);
        int actorReviewCount = actorReviewList.size();
        double sum = 0;
        for (Review reviewInList : actorReviewList) {
            sum += reviewInList.getReviewRating();
        }
        double actorPoint = sum/actorReviewCount;
        PrefActor prefActor = new PrefActor(user, actor, actorPoint, actorReviewCount, actorReviewDate); // PrefActor 생성
        prefActorRepository.save(prefActor); //PrefActors 테이블에 저장
    }


    // 민형 - 유저로 선호 배우 리스트
    @Override
    public List<PrefActor> prefActorList(User user) {
        return prefActorRepository.findByUser(user);
    }
}
