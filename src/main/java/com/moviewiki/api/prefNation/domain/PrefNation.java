package com.moviewiki.api.prefNation.domain;

import com.moviewiki.api.nation.domain.Nation;
import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PREF_NATIONS")
@IdClass(PrefNationPK.class)
public class PrefNation {

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    @Id
    private User user;

    @ManyToOne
    @JoinColumn(name ="NATION_ID")
    @Id
    private Nation nation;

    private double nationPoint;
    private int nationReviewCount;
    private Date nationReviewDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public double getNationPoint() {
        return nationPoint;
    }

    public void setNationPoint(double nationPoint) {
        this.nationPoint = nationPoint;
    }

    public int getNationReviewCount() {
        return nationReviewCount;
    }

    public void setNationReviewCount(int nationReviewCount) {
        this.nationReviewCount = nationReviewCount;
    }

    public Date getNationReviewDate() {
        return nationReviewDate;
    }

    public void setNationReviewDate(Date nationReviewDate) {
        this.nationReviewDate = nationReviewDate;
    }
}
