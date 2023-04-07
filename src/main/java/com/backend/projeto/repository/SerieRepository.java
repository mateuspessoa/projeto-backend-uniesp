package com.backend.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.projeto.entity.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {

}
