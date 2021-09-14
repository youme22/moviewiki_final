package com.moviewiki.api.prefActor.repository;

import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefActor.domain.PrefActorPK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefActorRepository extends JpaRepository<PrefActor, PrefActorPK> {
    
     PrefActor findPrefActorByUserAndActorId(User user, Long ActorId);
     void savePrefActor(PrefActor prefActor);
}