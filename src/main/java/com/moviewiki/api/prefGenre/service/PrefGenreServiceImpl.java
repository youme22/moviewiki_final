package com.moviewiki.api.prefGenre.service;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.repository.PrefGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PrefGenreServiceImpl implements PrefGenreService {

    @Autowired
    private PrefGenreRepository prefGenreRepository;

    private final EntityManager em;

    public PrefGenreServiceImpl(EntityManager em){
        this.em = em;
    }
    @Override
    public List<PrefGenre> findAll(){
        List<PrefGenre> prefGenreList =
                em.createQuery("select pg from PrefGenre pg",PrefGenre.class).getResultList();
        return prefGenreList;
    }
}
