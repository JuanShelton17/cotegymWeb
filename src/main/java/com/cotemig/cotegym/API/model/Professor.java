package com.cotemig.cotegym.API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private Integer idade;

	private Long cpf;
	
	private Integer modalidade_id;

//	@OneToMany(mappedBy = "professores")
//	private List<Ficha> fichas;


//	public void setFicha(Ficha ficha) {
//		this.fichas.add(ficha);
//
//	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

//	public List<Ficha> getFichas() {
//		return fichas;
//	}
//
//	public void setFichas(List<Ficha> fichas) {
//		this.fichas = fichas;
//	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModalidade_id() {
		return modalidade_id;
	}

	public void setModalidade_id(Integer modalidade_id) {
		this.modalidade_id = modalidade_id;
	}

}