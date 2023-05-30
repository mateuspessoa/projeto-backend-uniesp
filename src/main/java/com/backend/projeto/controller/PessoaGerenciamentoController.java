package com.backend.projeto.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.projeto.entity.Pessoa;
import com.backend.projeto.security.JwtUtil;
import com.backend.projeto.service.PessoaGerenciamentoService;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {
	
	@Autowired
	private PessoaGerenciamentoService pessoaGerenciamentoService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/senha-codigo")
	public String recuperarCodigo(@RequestBody Pessoa pessoa) {
		return pessoaGerenciamentoService.solicitarCodigo(pessoa.getEmail());
	}
	
	@PostMapping("/senha-alterar")
	public String alterarSenha(@RequestBody Pessoa pessoa) {
		return pessoaGerenciamentoService.alterarSenha(pessoa);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Pessoa pessoa){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(pessoa.getEmail(), pessoa.getSenha()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Pessoa autenticado = (Pessoa) authentication.getPrincipal();
		String token = jwtUtil.gerarTokenUsername(autenticado);
		HashMap<String, String> map = new HashMap<>();
		map.put("token", token);
		return ResponseEntity.ok(map);
	}

}
