package com.moviewiki.api.prefDirector.domain;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PREF_DIRECTORS")
@IdClass(PrefDirectorPK.class)
public class PrefDirector {

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    @Id
    private User user;

    @ManyToOne
    @JoinColumn(name ="DIRECTOR_ID")
    @Id
    private Director director;

    private double directorPoint;
    private int directorReviewCount;
    private Date directorReviewDate;

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Director getDirector() { return director; }

    public void setDirector(Director director) { this.director = director; }

    public double getDirectorPoint() { return directorPoint; }

    public void setDirectorPoint(double directorPoint) { this.directorPoint = directorPoint; }

    public int getDirectorReviewCount() { return directorReviewCount; }

    public void setDirectorReviewCount(int directorReviewCount) { this.directorReviewCount = directorReviewCount; }

    public Date getDirectorReviewDate() { return directorReviewDate; }

    public void setDirectorReviewDate(Date directorReviewDate) { this.directorReviewDate = directorReviewDate; }
}
