package com.backend.projeto.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.projeto.entity.Permissao;
import com.backend.projeto.entity.PermissaoPessoa;
import com.backend.projeto.entity.Pessoa;
import com.backend.projeto.repository.PermissaoPessoaRepository;
import com.backend.projeto.repository.PermissaoRepository;

@Service
public class PermissaoPessoaService {
	
	@Autowired
	private PermissaoPessoaRepository permissaoPessoaRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
public void vincularPessoaPermissaoCLiente(Pessoa pessoa) {
		
		List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");
		if(listaPermissao.size() > 0) {
			PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
			permissaoPessoa.setPessoa(pessoa);
			permissaoPessoa.setPermissao(listaPermissao.get(0));
			permissaoPessoa.setDataCriacao(new Date());
			permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
		}
	}

}
