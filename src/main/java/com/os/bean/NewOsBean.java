package com.os.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.os.generico.GenericBean;

/*
String teste ="teste"; 
String testeEncond = Base64.getEncoder().encodeToString(teste.getBytes());
String testeDecod = new String(Base64.getDecoder().decode(testeEncond));
*/



@ManagedBean
@ViewScoped
public class NewOsBean extends GenericBean {

	
	private String titulo;
	private String descricao;
	private Integer tipo;
	
	
	@PostConstruct
	public void init() {
		
		
	}
	
	
	
	
	// GATTERS AND SETTERS 
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	
}
