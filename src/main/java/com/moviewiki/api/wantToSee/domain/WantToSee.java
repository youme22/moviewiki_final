package com.moviewiki.api.wantToSee.domain;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(WantToSeePK.class)
@Table(name="want_to_see")
public class  WantToSee {

    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;
}
