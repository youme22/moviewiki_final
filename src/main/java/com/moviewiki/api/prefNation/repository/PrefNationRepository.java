package com.moviewiki.api.prefNation.repository;

import com.moviewiki.api.prefNation.domain.PrefNation;
import com.moviewiki.api.prefNation.domain.PrefNationPK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefNationRepository extends JpaRepository<PrefNation, PrefNationPK> {

     PrefNation findPrefNationByUserAndNationId(User user, String NationId);
     void savePrefNation(PrefNation prefNation);
}