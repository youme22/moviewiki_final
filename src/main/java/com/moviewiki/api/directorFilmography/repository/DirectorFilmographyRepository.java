package com.moviewiki.api.directorFilmography.repository;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.directorFilmography.domain.DirectorFilmography;
import com.moviewiki.api.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorFilmographyRepository extends JpaRepository<DirectorFilmography, Long> {
    public List<DirectorFilmography> findDirectorFilmographyByDirector(Director director);

    Director findDirectorByReview(Review review);
}
