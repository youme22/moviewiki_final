package com.moviewiki.api.season.domain;

import com.moviewiki.api.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SeasonPK.class)
@Table(name="seasons")
public class Season {

    @Id
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @Id
    private @Column(name = "season_name") String seasonName;

    private @Column(name = "season_point") int seasonPoint;
}
