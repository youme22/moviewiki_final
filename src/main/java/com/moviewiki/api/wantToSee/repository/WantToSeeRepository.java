package com.moviewiki.api.wantToSee.repository;

import com.moviewiki.api.wantToSee.domain.WantToSee;
import com.moviewiki.api.wantToSee.domain.WantToSeePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantToSeeRepository extends JpaRepository<WantToSee, WantToSeePK> {

    /* [미완성!!!] => 특정 사용자의 보고 싶은 영화 조회 -> 사용자 아이디로 기준 */
    public List<WantToSee> findByUser(String userId);

    /* [미완성!!!] => 보고싶은 영화 삭제 -> 사용자아이디, 영화아이디 */
    public void deleteByUserAndMovie(String userId, Long movieId);
}
