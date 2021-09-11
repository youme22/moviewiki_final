package com.moviewiki.api.following.domain;


import lombok.NoArgsConstructor;
import java.io.Serializable;
import lombok.Data;
import com.moviewiki.api.user.domain.User;

@Data
@NoArgsConstructor
public class FollowingPK implements Serializable {

    private User fromUser;
    private User toUser;

}
