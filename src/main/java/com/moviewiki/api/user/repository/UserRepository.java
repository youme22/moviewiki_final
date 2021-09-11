package com.moviewiki.api.user.repository;

import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserId(String userId);
    User findByUserIdAndAndUserPw(String userId, String userPw);
}
