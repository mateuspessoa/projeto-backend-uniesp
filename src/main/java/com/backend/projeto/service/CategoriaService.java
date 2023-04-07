package com.backend.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.projeto.entity.Categoria;
import com.backend.projeto.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}
	
	public Categoria inserir(Categoria categoria) {
		return categoriaRepository.saveAndFlush(categoria);
	}
	
	public Categoria alterar(Categoria categoria) {
		return categoriaRepository.saveAndFlush(categoria);
	}
	
	public void excluir(Long id) {
		try {
			Categoria categoria = categoriaRepository.findById(id).get();
			categoriaRepository.delete(categoria);
		} catch (Exception e) {
			throw new RuntimeException("Existem filmes ou séries cadastrados nessa categoria");
		}
	}

}