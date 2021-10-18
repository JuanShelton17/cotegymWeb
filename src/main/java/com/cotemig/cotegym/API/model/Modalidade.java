package com.cotemig.cotegym.API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private Boolean aerobico;
	
	//private Integer professor_id;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAerobico() {
		return aerobico;
	}

	public void setAerobico(Boolean aerobico) {
		this.aerobico = aerobico;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
