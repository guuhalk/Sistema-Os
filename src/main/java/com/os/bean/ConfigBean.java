package com.os.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.os.generico.GenericBean;

@ManagedBean
@ViewScoped
public class ConfigBean extends GenericBean {

	
	private  boolean rotinaCadastro;

	@PostConstruct
	public void init() {
		
		rotinaCadastro = false;
	}
	
	
	public void validaCadastro() {
		
		rotinaCadastro = true;
	}
	
	public void redirecionarPaginasUsuario() {
		redirecionarPagina("usuario.xhtml");
	}
	
	
	
	// GATTERS AND SETTERS
	public boolean getRotinaCadastro() {
		return rotinaCadastro;
	}

	public void setRotinaCadastro(boolean rotinaCadastro) {
		this.rotinaCadastro = rotinaCadastro;
	}
	
	
}
