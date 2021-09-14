package com.moviewiki.api.prefDirector.repository;

import com.moviewiki.api.prefDirector.domain.PrefDirector;
import com.moviewiki.api.prefDirector.domain.PrefDirectorPK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefDirectorRepository extends JpaRepository<PrefDirector, PrefDirectorPK> {

     PrefDirector findPrefDirectorByUserAndDirectorId(User user, Long DirectorId);
     void savePrefDirector(PrefDirector prefDirector);
}