package com.moviewiki.api.review.domain;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "REVIEW_ID")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name ="MOVIE_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    private User user;

    private Date reviewDate;
    private int ratingPoint;
    private String comment;
}
