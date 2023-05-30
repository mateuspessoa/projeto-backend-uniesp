package com.backend.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.projeto.entity.Pessoa;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {

}
