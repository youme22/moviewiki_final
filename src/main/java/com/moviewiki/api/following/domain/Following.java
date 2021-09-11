package com.moviewiki.api.following.domain;

import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "FOLLOWINGS")
@IdClass(FollowingPK.class)
public class Following {

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    @Id
    private User follower;

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    @Id
    private User followee;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowee() {
        return followee;
    }

    public void setFollowee(User followee) {
        this.followee = followee;
    }
}
