package com.backend.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.projeto.entity.Serie;
import com.backend.projeto.service.SerieService;

@RestController
@RequestMapping("/api/serie")
public class SerieController {
	
	@Autowired
	private SerieService serieService;
	
	@GetMapping("/")
	public List<Serie> buscarTodos() {
		return serieService.buscarTodos();
	}
	
	@PostMapping("/")
	public Serie inserir(@RequestBody Serie serie) {
		return serieService.inserir(serie);
	}
	
	@PutMapping("/")
	public Serie alterar(@RequestBody Serie serie) {
		return serieService.alterar(serie);
	}
	
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			serieService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
