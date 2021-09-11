package com.moviewiki.api.wantToSee.repository;

import com.moviewiki.api.wantToSee.domain.WantToSee;
import com.moviewiki.api.wantToSee.domain.WantToSeePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WantToSeeRepository extends JpaRepository<WantToSee, WantToSeePK> {
}
