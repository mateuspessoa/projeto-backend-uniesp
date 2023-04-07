package com.backend.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.projeto.entity.Serie;
import com.backend.projeto.repository.SerieRepository;

@Service
public class SerieService {
	
	@Autowired
	private SerieRepository serieRepository;
	
	public List<Serie> buscarTodos() {
		return serieRepository.findAll();
	}
	
	public Serie inserir(Serie serie) {
		return serieRepository.saveAndFlush(serie);
	}
	
	public Serie alterar(Serie serie) {
		return serieRepository.saveAndFlush(serie);
	}
	
	public void excluir(Long id) {
		Serie serie = serieRepository.findById(id).get();
		serieRepository.delete(serie);
	}

}