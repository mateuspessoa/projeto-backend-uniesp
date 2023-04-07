package com.backend.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.projeto.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
