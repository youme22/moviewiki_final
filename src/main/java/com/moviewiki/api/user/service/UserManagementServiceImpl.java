package com.moviewiki.api.user.service;

import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findByUserId(userId);
        return user;
    }

    @Override
    public User checkPw(String userId, String userPw) {
            User user = userRepository.findByUserIdAndAndUserPw(userId, userPw);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
