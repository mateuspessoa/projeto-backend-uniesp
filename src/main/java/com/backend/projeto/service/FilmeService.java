package com.backend.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.projeto.entity.Filme;
import com.backend.projeto.repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<Filme> buscarTodos() {
		return filmeRepository.findAll();
	}
	
	public Filme buscarPorId(Long id) {
		Filme filme = filmeRepository.findById(id).get();
		return filme;
	}
	
	public Filme inserir(Filme filme) {
		return filmeRepository.saveAndFlush(filme);
	}
	
	public Filme alterar(Filme filme) {
		return filmeRepository.saveAndFlush(filme);
	}
	
	public void excluir(Long id) {
		Filme filme = filmeRepository.findById(id).get();
		filmeRepository.delete(filme);
	}

}