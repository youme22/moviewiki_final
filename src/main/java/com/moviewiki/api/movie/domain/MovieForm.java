package com.moviewiki.api.movie.domain;

import lombok.AllArgsConstructor;
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

}