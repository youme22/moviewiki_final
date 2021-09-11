package com.moviewiki.api.prefGenre.repository;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.domain.PrefGenrePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefGenreRepository extends JpaRepository<PrefGenre, PrefGenrePK> {

    PrefGenre findPrefGenreByUserIdAndGenreId(String userId, String GenreId);
    void updatePrefGenre(PrefGenre prefGenre);

}
