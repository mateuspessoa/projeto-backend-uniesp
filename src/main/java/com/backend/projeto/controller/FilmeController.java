package com.backend.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.projeto.entity.Filme;
import com.backend.projeto.service.FilmeService;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping("/")
	public List<Filme> buscarTodos() {
		return filmeService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Filme buscarPorId(@PathVariable("id") Long id) {
		return filmeService.buscarPorId(id);
	}
	
	@PostMapping("/cadastro/")
	public Filme inserir(@RequestBody Filme filme) {
		return filmeService.inserir(filme);
	}
	
	@PutMapping("/cadastro/")
	public Filme alterar(@RequestBody Filme filme) {
		return filmeService.alterar(filme);
	}
	
	@DeleteMapping("/cadastro/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			filmeService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
