package com.moviewiki.api.prefGenre.repository;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.domain.PrefGenrePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrefGenreRepository extends JpaRepository<PrefGenre, PrefGenrePK> {


//     void savePrefGenre(PrefGenre prefGenre);
    public List<PrefGenre> findAll();


}