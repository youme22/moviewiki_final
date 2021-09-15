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
@Table(name="WANT_TO_SEE")
public class  WantToSee {

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MOVIE_ID")
    private Movie movie;
}
