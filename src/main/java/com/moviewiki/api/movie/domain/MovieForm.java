package com.moviewiki.api.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieForm {

    private String movieName;
    private String movieOgName;
    private String directorName;
    private String actorName;
    private String nationId;
    private String movieProfile;
    private String runningTime;
    private String releaseDate;
    private String filmRating;
    private String genreId;
    private String summary;


    // 검색 TEST
    public Movie toEntity(){
        Movie movie = Movie.builder()
                .movieName(movieName)
                .movieOgName(movieOgName)
                .movieProfile(movieProfile)
                .filmRating(filmRating)
                .build();
        return movie;
    }

    @Builder
    public MovieForm(String movieName, String movieOgName, String movieProfile, String filmRating) {
        this.movieName = movieName;
        this.movieOgName = movieOgName;
        this.movieProfile = movieProfile;
        this.filmRating = filmRating;
    }
}