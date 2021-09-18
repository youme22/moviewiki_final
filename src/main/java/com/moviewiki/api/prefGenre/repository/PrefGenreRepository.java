package com.moviewiki.api.prefGenre.repository;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.domain.PrefGenrePK;
import com.moviewiki.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrefGenreRepository extends JpaRepository<PrefGenre, PrefGenrePK> {


//     void savePrefGenre(PrefGenre prefGenre);
//     void savePrefGenre(PrefGenre prefGenre);

    // 추천 Test2
    public List<PrefGenre> findByUser(User user);
//    public List<MovieGenre> findByGenre();
}