package com.os.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.os.generico.GenericBean;
import com.os.model.Interacao;
import com.os.model.OsChamado;



@ManagedBean
@SessionScoped
public class InteracaoOsBean extends GenericBean {

	private Integer idUsuarioLogado;
	private String nomeUsuarioLogado;
	private OsChamado osSelecionada;
	private String descricaoDaInteracao; 
	private Integer perfilUsuarioLogado;
	private Integer statusOs;
	private List<Interacao> listaDeInteracao;
	
	
	
	
	public void redirecionarParaInteracao(OsChamado os) {
		redirecionarPagina("os-interacao.xhtml");
		this.osSelecionada = os;
		idUsuarioLogado = buscaUsuarioSessao().getUsuId();
		nomeUsuarioLogado = buscaUsuarioSessao().getUsuNome();
		perfilUsuarioLogado = buscaUsuarioSessao().getPrfId().getPrfId();
			
	}



	public void redirecionarPaginasOs() {
		
		if(perfilUsuarioLogado == 1 || perfilUsuarioLogado == 3) {
			redirecionarPagina("os-analista.xhtml");
		}else {
			redirecionarPagina("os-usuario.xhtml");
		}
	}
	
	
	// GATTERS AND SETTERS 

	public Integer getIdUsuarioLogado() {
		return idUsuarioLogado;
	}

	public void setIdUsuarioLogado(Integer idUsuarioLogado) {
		this.idUsuarioLogado = idUsuarioLogado;
	}

	public OsChamado getOsSelecionada() {
		return osSelecionada;
	}

	public void setOsSelecionada(OsChamado osSelecionada) {
		this.osSelecionada = osSelecionada;
	}


	public String getNomeUsuarioLogado() {
		return nomeUsuarioLogado;
	}


	public void setNomeUsuarioLogado(String nomeUsuarioLogado) {
		this.nomeUsuarioLogado = nomeUsuarioLogado;
	}


	public String getDescricaoDaInteracao() {
		return descricaoDaInteracao;
	}


	public void setDescricaoDaInteracao(String descricaoDaInteracao) {
		this.descricaoDaInteracao = descricaoDaInteracao;
	}


	public Integer getStatusOs() {
		return statusOs;
	}


	public void setStatusOs(Integer statusOs) {
		this.statusOs = statusOs;
	}






	public List<Interacao> getListaDeInteracao() {
		return listaDeInteracao;
	}






	public void setListaDeInteracao(List<Interacao> listaDeInteracao) {
		this.listaDeInteracao = listaDeInteracao;
	}

}
