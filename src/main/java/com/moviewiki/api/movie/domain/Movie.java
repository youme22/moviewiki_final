package com.moviewiki.api.movie.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "MOVIE_ID")
    private String movieId;

    private String movieName;
    private String movieOgName;
    private String movieProfile;
    private Date releaseDate;
    private String filmRating;
    private int runningtime;
    private String summary;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieOgName() {
        return movieOgName;
    }

    public void setMovieOgName(String movieOgName) {
        this.movieOgName = movieOgName;
    }

    public String getMovieProfile() {
        return movieProfile;
    }

    public void setMovieProfile(String movieProfile) {
        this.movieProfile = movieProfile;
    }

    public Date getReleaseDate() { return releaseDate; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public String getFilmRating() { return filmRating; }

    public void setFilmRating(String filmRating) { this.filmRating = filmRating; }

    public int getRunningtime() { return runningtime; }

    public void setRunningtime(int runningtime) { this.runningtime = runningtime; }

    public String getSummary() { return summary; }

    public void setSummary(String summary) { this.summary = summary; }

}
