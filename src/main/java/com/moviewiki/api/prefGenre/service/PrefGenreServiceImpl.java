package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movieGenre.repository.MovieGenreRepository;
import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.repository.PrefGenreRepository;
import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.review.repository.ReviewRepository;
import com.moviewiki.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class PrefGenreServiceImpl implements PrefGenreService {

    @Autowired
    private PrefGenreRepository prefGenreRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieGenreRepository movieGenreRepository;
    @Autowired
    private final EntityManager em;

    public PrefGenreServiceImpl(EntityManager em) {
        this.em = em;
    }


//    public PrefGenreServiceImpl(PrefGenreRepository prefGenreRepository, ReviewRepository reviewRepository, MovieGenreRepository movieGenreRepository, EntityManager em) {
//        this.prefGenreRepository = prefGenreRepository;
//        this.reviewRepository = reviewRepository;
//        this.movieGenreRepository = movieGenreRepository;
//        this.em = em;
//    }


    // 효미 - 장르 선호도 업데이트
    @Override
    public void updatePrefGenre(Review review) {
        User user = review.getUser();
        Date genreReviewDate = new Date();
        Genre genre = movieGenreRepository.findGenreByMovie(review.getMovie());
        List<Review> genreReviewList = reviewRepository.findGenreReviewListByUserAndGenre(user, genre);
        int genreReviewCount = genreReviewList.size();
        double sum = 0;
        for (Review reviewInList : genreReviewList) {
            sum += reviewInList.getReviewRating();
        }
        double genrePoint = sum/genreReviewCount;
        PrefGenre prefGenre = new PrefGenre(user, genre, genrePoint, genreReviewCount, genreReviewDate); // PrefGenre 생성
        prefGenreRepository.save(prefGenre); //PrefGenres 테이블에 저장
    }


    // 선호 장르 영화 추천
    @Override
    public List<Movie> findAll(){
        String sql = "SELECT * FROM MOVIES\n" +
                "WHERE MOVIE_ID IN(\n" +
                "SELECT MOVIE_ID FROM MOVIE_GENRE\n" +
                "WHERE GENRE_ID IN\n" +
                "    (SELECT GENRE_ID from PREF_GENRES \n" +
                "    where GENRE_POINT =\n" +
                "        (select max(GENRE_POINT) from PREF_GENRES where USER_ID = 'veddy0')))";
        List<Movie> recGenreList = em.createNativeQuery(sql, Movie.class).getResultList();
        return recGenreList.subList(0, 12);
    }


    // 민형 - 유저로 선호 장르 리스트
    @Override
    public List<PrefGenre> prefGenreList(User user) {
        return prefGenreRepository.findByUser(user);
    }

}
