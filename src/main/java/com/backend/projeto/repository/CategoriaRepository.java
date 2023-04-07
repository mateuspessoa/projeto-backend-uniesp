package com.backend.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.projeto.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
