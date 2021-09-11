package com.moviewiki.api.following.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.moviewiki.api.user.domain.User;

@Entity
@Data
@NoArgsConstructor
@IdClass(FollowingPK.class)
@Table(name="following")
public class Following {

    @Id
    @ManyToOne
    @JoinColumn(name="fromUser")
    private User fromUser;

    @Id
    @ManyToOne
    @JoinColumn(name="toUser")
    private User toUser;

    @Builder
    public Following(User fromUser, User toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}