package com.cotemig.cotegym.API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemFicha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer exercicio_id;
	
	private String descricao;
	
	private Integer serie;
	
	private Integer repeticao;
	
	private Integer descanso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExercicio_id() {
		return exercicio_id;
	}

	public void setExercicio_id(Integer exercicio_id) {
		this.exercicio_id = exercicio_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(Integer repeticao) {
		this.repeticao = repeticao;
	}

	public Integer getDescanso() {
		return descanso;
	}

	public void setDescanso(Integer descanso) {
		this.descanso = descanso;
	}
}