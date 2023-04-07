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

import com.backend.projeto.entity.Categoria;
import com.backend.projeto.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/")
	public List<Categoria> buscarTodos() {
		return categoriaService.buscarTodos();
	}
	
	@PostMapping("/")
	public Categoria inserir(@RequestBody Categoria categoria) {
		return categoriaService.inserir(categoria);
	}
	
	@PutMapping("/")
	public Categoria alterar(@RequestBody Categoria categoria) {
		return categoriaService.alterar(categoria);
	}
	
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			categoriaService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
