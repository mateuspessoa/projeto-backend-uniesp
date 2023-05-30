package com.backend.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.projeto.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByNome(String Nome);

}
