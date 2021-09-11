package com.moviewiki.api.prefDirector.repository;

import com.moviewiki.api.prefDirector.domain.PrefDirector;
import com.moviewiki.api.prefDirector.domain.PrefDirectorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefDirectorRepository extends JpaRepository<PrefDirector, PrefDirectorPK> {
    PrefDirector findPrefDirectorByUserIdAndDirectorId(String userId, String DirectorId);
    void updatePrefDirector(PrefDirector prefDirector);
}
