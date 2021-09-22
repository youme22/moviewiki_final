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

    private PrefGenreRepository prefGenreRepository;
    private ReviewRepository reviewRepository;
    private MovieGenreRepository movieGenreRepository;

    private final EntityManager em;

    public PrefGenreServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public PrefGenreServiceImpl(PrefGenreRepository prefGenreRepository, ReviewRepository reviewRepository, MovieGenreRepository movieGenreRepository, EntityManager em) {

        this.prefGenreRepository = prefGenreRepository;
        this.reviewRepository = reviewRepository;
        this.movieGenreRepository = movieGenreRepository;

        this.em = em;
    }

    @Override
    public void updatePrefGenre(Review review) {

        User user = review.getUser();
        Date genreReviewDate = null; // updatePrefGenre메소드가 호출되는 날짜
        Genre genre = movieGenreRepository.findGenreByMovie(review.getMovie());
//        List<Review> genreReviewList = reviewRepository.findGenreReviewListByUserIdAndGenreId(user.getUserId(), genre.getGenreId());
        List<Review> genreReviewList = reviewRepository.findDirectorReviewListByUser(user); //임시코드 삭제예정
        int genreReviewCount = genreReviewList.size(); // 메소드 아무거나 고름 -> 리뷰 카운트 메소드로 변경 예정
        double genrePoint = genreReviewList.hashCode(); // 메소드 아무거나 고름 -> 선호도 계산 메소드로 변경 예정, 평점(-3)의 총합을 genreReviewCount로 나눈 값
        PrefGenre prefGenre = new PrefGenre(user, genre, genrePoint, genreReviewCount, genreReviewDate); // PrefGenre 생성
//        prefGenreRepository.savePrefGenre(prefGenre); //PrefGenre 테이블에 저장

    }

    // 선호 장르 영화 추천
    @Override
    public List<Movie> findAll(){
        String sql = "SELECT * FROM MOVIES\n" +
                "WHERE MOVIE_ID IN(\n" +
                "SELECT MOVIE_ID FROM MOVIE_GENRE\n" +
                "WHERE GENRE_ID IN\n" +
                "    (SELECT GENRE_ID from PREF_GENRES \n" +
                "    where GENREPOINT =\n" +
                "        (select max(GENREPOINT) from PREF_GENRES where USER_ID = 'test1')))";
        List<Movie> recMovieList = em.createNativeQuery(sql, Movie.class).getResultList();
        return recMovieList;
    }

    // 민형 - 유저로 선호 장르 리스트
    @Override
    public List<PrefGenre> prefGenreList(User user) {
        return prefGenreRepository.findByUser(user);
    }
}
