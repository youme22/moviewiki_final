package com.moviewiki.api.wantToSee.service;

import com.moviewiki.api.wantToSee.domain.WantToSee;

import java.util.List;

public interface WantToSeeService {

    /* 보고싶은 영화 추가 */
    public void save(WantToSee wantToSee);

    /* 특정 사용자의 보고 싶은 영화 조회 -> 사용자 아이디로 기준 */
    public List<WantToSee> findByUser(String userId);

    /* 보고싶은 영화 삭제 -> 사용자아이디, 영화아이디 */
    public void deleteByUserAndMovie(String userId, Long movieId);
}
