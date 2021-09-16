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
    public void updateUser(User user) {
        userRepository.save(user);
    }


    @Override
    public User findId(String userName, String userMail) {
        User user = userRepository.findUserByUserNameAndUserMail(userName, userMail);
        return user;
    }

}
