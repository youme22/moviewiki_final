package com.moviewiki.api.director.repository;

import com.moviewiki.api.director.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, String> {
}
