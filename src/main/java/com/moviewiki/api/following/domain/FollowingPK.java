package com.moviewiki.api.following.domain;

import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FollowingPK implements Serializable {
    private User follower;
    private User followee;
}
