package com.moviewiki.api.prefGenre.repository;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.domain.PrefGenrePK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefGenreRepository extends JpaRepository<PrefGenre, PrefGenrePK> {

     PrefGenre findPrefGenreByUserAndGenreId(User user, String GenreId);
     void savePrefGenre(PrefGenre prefGenre);

}