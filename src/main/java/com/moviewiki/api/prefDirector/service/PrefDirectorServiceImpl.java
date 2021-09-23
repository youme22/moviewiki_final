package com.moviewiki.api.prefDirector.service;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.directorFilmography.repository.DirectorFilmographyRepository;
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

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PrefDirectorRepository prefDirectorRepository;
    @Autowired
    private DirectorFilmographyRepository directorFilmographyRepository;

//    @Autowired
//    public PrefDirectorServiceImpl(ReviewRepository reviewRepository, PrefDirectorRepository prefDirectorRepository, DirectorFilmographyRepository directorFilmographyRepository) {
//
//        this.reviewRepository = reviewRepository;
//        this.prefDirectorRepository = prefDirectorRepository;
//        this.directorFilmographyRepository = directorFilmographyRepository;
//
//    }

    // 효미 - 감독 선호도 업데이트
    @Override
    public void updatePrefDirector(Review review) {
        User user = review.getUser();
        Date directorReviewDate = new Date();
        Director director = directorFilmographyRepository.findDirectorByMovie(review.getMovie());
        List<Review> directorReviewList = reviewRepository.findDirectorReviewListByUserAndDirector(user, director);
        int directorReviewCount = directorReviewList.size();
        double sum = 0;
        for (Review reviewInList : directorReviewList) {
            sum += reviewInList.getReviewRating();
        }
        double directorPoint = sum/directorReviewCount;
        PrefDirector prefDirector = new PrefDirector(user, director, directorPoint, directorReviewCount, directorReviewDate); // PrefDirector 생성
        prefDirectorRepository.save(prefDirector); //PrefDirectors 테이블에 저장
    }

    // 민형 - 유저로 선호 액터 리스트
    @Override
    public List<PrefDirector> prefDirectorList(User user) {
        return prefDirectorRepository.findByUser(user);
    }
}
