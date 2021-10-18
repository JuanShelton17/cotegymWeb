package com.cotemig.cotegym.API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ficha {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tipoFicha; //HIPERTROFIA, EMAGRECIMENT0, DEFINIÇÃO;
	
	private String fichaLetra;
	
	private Integer professor_id;
	
	private Integer aluno_id;
	
	private Integer itemExercicio1_id;
	
	private Integer itemExercicio2_id;
	
	private Integer itemExercicio3_id;
	
	private Integer itemExercicio4_id;

	public String getTipoFicha() {
		return tipoFicha;
	}

	public void setTipoFicha(String tipoFicha) {
		this.tipoFicha = tipoFicha;
	}

	public String getFichaLetra() {
		return fichaLetra;
	}

	public void setFichaLetra(String fichaLetra) {
		this.fichaLetra = fichaLetra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Integer professor_id) {
		this.professor_id = professor_id;
	}

	public Integer getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(Integer aluno_id) {
		this.aluno_id = aluno_id;
	}

	public Integer getItemExercicio1_id() {
		return itemExercicio1_id;
	}

	public void setItemExercicio1_id(Integer itemExercicio1_id) {
		this.itemExercicio1_id = itemExercicio1_id;
	}

	public Integer getItemExercicio2_id() {
		return itemExercicio2_id;
	}

	public void setItemExercicio2_id(Integer itemExercicio2_id) {
		this.itemExercicio2_id = itemExercicio2_id;
	}

	public Integer getItemExercicio3_id() {
		return itemExercicio3_id;
	}

	public void setItemExercicio3_id(Integer itemExercicio3_id) {
		this.itemExercicio3_id = itemExercicio3_id;
	}

	public Integer getItemExercicio4_id() {
		return itemExercicio4_id;
	}

	public void setItemExercicio4_id(Integer itemExercicio4_id) {
		this.itemExercicio4_id = itemExercicio4_id;
	}
}