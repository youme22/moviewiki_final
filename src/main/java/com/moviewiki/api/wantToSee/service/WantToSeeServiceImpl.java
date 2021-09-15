package com.moviewiki.api.wantToSee.service;

import com.moviewiki.api.wantToSee.domain.WantToSee;
import com.moviewiki.api.wantToSee.repository.WantToSeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantToSeeServiceImpl implements WantToSeeService{

    @Autowired
    private WantToSeeRepository wantToSeeRepository;

    @Override
    public void save(WantToSee wantToSee) {
        wantToSeeRepository.save(wantToSee);
    }

    @Override
    public List<WantToSee> findByUser(String userId) {
        return wantToSeeRepository.findByUser(userId);
    }

    @Override
    public void deleteByUserAndMovie(String userId, Long movieId) {
        wantToSeeRepository.deleteByUserAndMovie(userId, movieId);
    }
}
