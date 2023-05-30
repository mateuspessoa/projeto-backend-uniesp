package com.backend.projeto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "serie")
@Data
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	private String lancamento;
	private String episodios;
	private String temporadas;
	private String sinopse;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;

}
