package com.moviewiki.api.like.domain;

import com.moviewiki.api.review.domain.Review;
import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LIKES")
@IdClass(LikePK.class)
public class Like {

    @ManyToOne
    @JoinColumn(name ="REVIEW_ID")
    @Id
    private Review review;

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    @Id
    private User user;

    public Review getReview() { return review; }

    public void setReview(Review review) { this.review = review; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
