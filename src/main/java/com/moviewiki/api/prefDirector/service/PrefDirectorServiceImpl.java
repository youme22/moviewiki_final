package com.moviewiki.api.prefDirector.service;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.directorFilmography.repository.DirectorFilmographyRepository;
import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefDirector.domain.PrefDirector;
import com.moviewiki.api.prefDirector.repository.PrefDirectorRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PrefDirectorServiceImpl implements PrefDirectorService {

    private ReviewRepository reviewRepository;
    private PrefDirectorRepository prefDirectorRepository;
    private DirectorFilmographyRepository directorFilmographyRepository;

    @Autowired
    public PrefDirectorServiceImpl(ReviewRepository reviewRepository, PrefDirectorRepository prefDirectorRepository, DirectorFilmographyRepository directorFilmographyRepository) {

        this.reviewRepository = reviewRepository;
        this.prefDirectorRepository = prefDirectorRepository;
        this.directorFilmographyRepository = directorFilmographyRepository;

    }

    @Override
    public void updatePrefDirector(Review review) {

        User user = review.getUser();
        Date directorReviewDate = null; // updatePrefDirector메소드가 호출되는 날짜
        Director director = directorFilmographyRepository.findDirectorByMovie(review.getMovie());
//        List<Review> directorReviewList = reviewRepository.findDirectorReviewListByUserIdAndDirectorId(user.getUserId(), director.getDirectorId());
        List<Review> directorReviewList = reviewRepository.findNationGReviewListByUser(user); //임시코드 삭제예정
        int directorReviewCount = directorReviewList.size(); // 메소드 아무거나 고름 -> 리뷰 카운트 메소드로 변경 예정
        double directorPoint = directorReviewList.hashCode(); // 메소드 아무거나 고름 -> 선호도 계산 메소드로 변경 예정, 평점(-3)의 총합을 directorReviewCount로 나눈 값
        PrefDirector prefDirector = new PrefDirector(user, director, directorPoint, directorReviewCount, directorReviewDate); // PrefDirector 생성
//        prefDirectorRepository.savePrefDirector(prefDirector); //PrefDirector 테이블에 저장

    }

    // 민형 - 유저로 선호 감독 리스트(선호 점수순)
    @Override
    public List<PrefDirector> prefDirectorList(User user) {
        List<PrefDirector> prefDirectorList = prefDirectorRepository.findByUserOrderByDirectorPointDesc(user);
        return prefDirectorList.subList(0,3);
    }
}
