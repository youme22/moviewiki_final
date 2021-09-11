package com.moviewiki.api.review.domain;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "REVIEW_ID")
    private String reviewId;

    @ManyToOne
    @JoinColumn(name ="MOVIE_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    private User user;

    private Date reviewDate;
    private int ratingPoint;
    private String comment;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Movie getMovie() { return movie; }

    public void setMovie(Movie movie) { this.movie = movie; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(int ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public String getComment() { return comment; }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
