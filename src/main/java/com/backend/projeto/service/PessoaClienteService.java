package com.backend.projeto.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.projeto.dto.PessoaClienteRequestDTO;
import com.backend.projeto.entity.Pessoa;
import com.backend.projeto.repository.PessoaClienteRepository;

@Service
public class PessoaClienteService {
	
	@Autowired
	private PessoaClienteRepository pessoaRepository;
	
	@Autowired
	private PermissaoPessoaService permissaoPessoaService;
	
	@Autowired
	private EmailService emailService;
	
	public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
		pessoa.setDataCriacao(new Date());
		Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
		permissaoPessoaService.vincularPessoaPermissaoCLiente(pessoaNova);
		//emailService.enviarEmailTexto(pessoaNova.getEmail(), "Cadastro na Loja Teste", "O registro foi realizado com sucesso");
		Map<String, Object> propMap = new HashMap<>();
		propMap.put("nome", pessoaNova.getNome());
		propMap.put("mensagem", "O seu cadastro foi realizado com sucesso!");
		emailService.enviarEmailTemplate(pessoaNova.getEmail(), "Cadastro Realizado Uniesp", propMap);
		return pessoaNova;
	}
	
	public Pessoa atualizarDados(Long pessoaId, PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoaExistente = pessoaRepository.findById(pessoaId)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

		BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoaExistente, "id", "dataCriacao");

		Pessoa pessoaAtualizada = pessoaRepository.save(pessoaExistente);

		return pessoaAtualizada;
	}

}
