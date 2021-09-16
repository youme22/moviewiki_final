package com.moviewiki.api.user.service;

import com.moviewiki.api.user.domain.User;

public interface UserManagementService {
    void createUser(User user);

    void deleteUser(String userId);

    User getUser(String userId);

    void updateUser(User user);

    User findId(String userName, String userMail);

    User checkPw(String userId, String userPw);
}
