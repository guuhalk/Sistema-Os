package com.os.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity (name="Perfil")
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prf_id", nullable=false)
	private Integer prfId;
	
	@Column(name="prf_descricao", nullable=false)
	private String  prfDescricao;
	
	@Column(name="prf_ativo", nullable=false)
	private  Integer prfAtivo;
	

	public Perfil() {
		
	}


	// GATTERS AND SETTERS
	public Integer getPrfId() {
		return prfId;
	}


	public void setPrfId(Integer prfId) {
		this.prfId = prfId;
	}


	public String getPrfDescricao() {
		return prfDescricao;
	}


	public void setPrfDescricao(String prfDescricao) {
		this.prfDescricao = prfDescricao;
	}


	public Integer getPrfAtivo() {
		return prfAtivo;
	}


	public void setPrfAtivo(Integer prfAtivo) {
		this.prfAtivo = prfAtivo;
	}



	
}
