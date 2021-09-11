package com.moviewiki.api.following.domain;

import java.io.Serializable;

import lombok.Data;
import com.moviewiki.api.user.domain.User;

@Data
public class FollowingPK implements Serializable {

    private User fromUser;
    private User toUser;

}