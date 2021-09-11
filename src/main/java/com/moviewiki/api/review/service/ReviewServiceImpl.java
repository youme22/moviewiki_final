package com.moviewiki.api.review.service;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.like.repository.LikeRepository;
import com.moviewiki.api.prefActor.repository.PrefActorRepository;
import com.moviewiki.api.prefDirector.repository.PrefDirectorRepository;
import com.moviewiki.api.prefGenre.repository.PrefGenreRepository;
import com.moviewiki.api.prefNation.repository.PrefNationRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private LikeRepository likeRepository;
    private PrefGenreRepository prefGenreRepository;
    private PrefNationRepository prefNationRepository;
    private PrefDirectorRepository prefDirectorRepository;
    private PrefActorRepository prefActorRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, LikeRepository likeRepository, PrefGenreRepository prefGenreRepository, PrefNationRepository prefNationRepository, PrefDirectorRepository prefDirectorRepository, PrefActorRepository prefActorRepository) {
        this.reviewRepository = reviewRepository;
        this.likeRepository = likeRepository;
        this.prefGenreRepository = prefGenreRepository;
        this.prefNationRepository = prefNationRepository;
        this.prefDirectorRepository = prefDirectorRepository;
        this.prefActorRepository = prefActorRepository;
    }


    @Override
    public void doReview(Review review) {
    }

    @Override
    public void modifyReview(Review review) {

    }

    @Override
    public void deleteReview(String reviewId) {

    }

    @Override
    public void likeReview(Like like) {

    }

    @Override
    public void unlikeReview(Like like) {

    }
}
