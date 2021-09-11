package com.moviewiki.api.prefActor.repository;

import com.moviewiki.api.prefActor.domain.PrefActor;
import com.moviewiki.api.prefActor.domain.PrefActorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefActorRepository extends JpaRepository<PrefActor, PrefActorPK> {
    PrefActor findPrefActorByUserIdAndActorId(String userId, String ActorId);
    void updatePrefActor(PrefActor prefActor);
}
