package com.moviewiki.api.like.repository;

import com.moviewiki.api.like.domain.Like;
import com.moviewiki.api.like.domain.LikePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikePK> {

    void addLike(Like like);
    void deleteLike(Like like);

}
