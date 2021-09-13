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

}
