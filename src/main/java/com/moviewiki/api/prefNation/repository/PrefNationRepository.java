package com.moviewiki.api.prefNation.repository;

import com.moviewiki.api.prefNation.domain.PrefNation;
import com.moviewiki.api.prefNation.domain.PrefNationPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefNationRepository extends JpaRepository<PrefNation, PrefNationPK> {
    PrefNation findPrefNationByUserIdAndNationId(String userId, String NationId);
    void updatePrefNation(PrefNation prefNation);
}
