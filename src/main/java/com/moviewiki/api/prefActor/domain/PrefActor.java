package com.moviewiki.api.prefActor.domain;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PREF_ACTORS")
@IdClass(PrefActorPK.class)
public class PrefActor {

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    @Id
    private User user;

    @ManyToOne
    @JoinColumn(name ="ACTOR_ID")
    @Id
    private Actor actor;

    private double actorPoint;
    private int actorReviewCount;
    private Date actorReviewDate;

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Actor getActor() { return actor; }

    public void setActor(Actor actor) { this.actor = actor; }

    public double getActorPoint() { return actorPoint; }

    public void setActorPoint(double actorPoint) { this.actorPoint = actorPoint; }

    public int getActorReviewCount() { return actorReviewCount; }

    public void setActorReviewCount(int actorReviewCount) { this.actorReviewCount = actorReviewCount; }

    public Date getActorReviewDate() { return actorReviewDate; }

    public void setActorReviewDate(Date actorReviewDate) { this.actorReviewDate = actorReviewDate; }
}
