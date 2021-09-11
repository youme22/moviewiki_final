package com.moviewiki.api.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "MOVIE_SEQ_GENERATOR",
        sequenceName = "MOVIE_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    , generator = "MOVIE_SEQ_GENERATOR")
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "film_rating")
    private String filmRating;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_og_name")
    private String movieOgName;
    @Column(name = "movie_profile")
    private String movieProfile;
    @Column(name = "release_date", columnDefinition = "DATE")
    private Date releaseDate;
    private int runningTime;
    @Column(columnDefinition = "LONG")
    private String summary;
    @Column(name = "avg_rating")
    private double avgRating;
    @Column(name = "review_count")
    private int reviewCount;
    @Column(name = "wts_count")
    private int wtsCount;

    public Movie(String filmRating, String movieName, String movieOgName, String movieProfile, Date releaseDate, int runningTime, String summary, double avgRating, int reviewCount, int wtsCount) {
        this.filmRating = filmRating;
        this.movieName = movieName;
        this.movieOgName = movieOgName;
        this.movieProfile = movieProfile;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.summary = summary;
        this.avgRating = avgRating;
        this.reviewCount = reviewCount;
        this.wtsCount = wtsCount;
    }
}
