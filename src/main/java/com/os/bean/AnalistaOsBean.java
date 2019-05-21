package com.os.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.os.generico.GenericBean;



@ManagedBean
@ViewScoped
public class AnalistaOsBean extends GenericBean{

	
	public void redirecionarPaginasParaAlocar() {
		redirecionarPagina("os-alocar.xhtml"); 
	}
	
	public void redirecionarPaginasParaPesquisarOs() {
		redirecionarPagina("os-pesquisar.xhtml"); 
	}

	
	
}
