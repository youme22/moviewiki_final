package com.moviewiki.api.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieForm {

    private String movieName;
    private String movieOgName;
    private String directorName;
    private String actorName;
    private String nationName;
    private String movieProfile;
    private String runningTime;
    private String releaseDate;
    private String filmRating;
    private String genreId;
    private String summary;
}
