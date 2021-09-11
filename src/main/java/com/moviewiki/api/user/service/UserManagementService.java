package com.moviewiki.api.user.service;

import com.moviewiki.api.user.domain.User;

public interface UserManagementService {
    void createUser(User user);

    void deleteUser(String userId);

    User getUser(String userId);

    User checkPw(String userId, String userPw);

    void updateUser(User user);
}
