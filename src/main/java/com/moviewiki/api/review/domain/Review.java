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

    @Column(name= "REVIEW_DATE")    // 민형 - 추가
    private Date reviewDate;

    @Column(name= "RATING_POINT")   // 민형 - 추가
    private double ratingPoint; // 0.5단위

    @Column(name= "COMMENTS") // 예약어라서 못쓴대서 s 붙였습니다
    private String comment;

}
