package com.os.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.os.generico.GenericBean;

@ManagedBean
@ViewScoped
public class IndexBean extends GenericBean {

	private String usuarioLogado;
	private Integer perfilUsuarioLogado;

	@PostConstruct
	public void init() {

		usuarioLogado = buscaUsuarioSessao().getUsuNome();
		perfilUsuarioLogado = buscaUsuarioSessao().getPrfId().getPrfId();

	}

	

	
	// METODOS PARA REDIRECIONAR AS PAGINAS DA INDEX
	public String redirecionarParaIndex() {

		return "../index.xhtml?faces-redirect=true";

	}

	public void redirecionarPaginasOs() {
		
		if(perfilUsuarioLogado == 1 || perfilUsuarioLogado == 3) {
			redirecionarPagina("os/os-analista.xhtml");
		}else {
			redirecionarPagina("os/os-usuario.xhtml");
		}
	}
	
	public void redirecionarPaginasSettings() {
		redirecionarPagina("config/config.xhtml");
	}
	
	public void redirecionarPaginasRelatorios() {
		redirecionarPagina("relatorios/relatorios.xhtml");
	}
	

	// GATTERS AND SETTERS
	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Integer getPerfilUsuarioLogado() {
		return perfilUsuarioLogado;
	}

	public void setPerfilUsuarioLogado(Integer perfilUsuarioLogado) {
		this.perfilUsuarioLogado = perfilUsuarioLogado;
	}

}
