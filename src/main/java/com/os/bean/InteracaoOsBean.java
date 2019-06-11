package com.os.bean;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.os.dao.InteracaoOsDao;
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
	private boolean rowAnalista;
	private boolean rowUsuario;
	private boolean rowUsuarioTeste;
	private Interacao download;
	
	
	
	
	public void redirecionarParaInteracao(OsChamado os) throws UnsupportedEncodingException {
		
		if(os.getAnalistaOs() != null) {
		
			redirecionarPagina("os-interacao.xhtml");
			this.osSelecionada = os;
			idUsuarioLogado = buscaUsuarioSessao().getUsuId();
			nomeUsuarioLogado = buscaUsuarioSessao().getUsuNome();
			perfilUsuarioLogado = buscaUsuarioSessao().getPrfId().getPrfId();
			listaDeInteracao = new InteracaoOsDao().buscarInteracaoDoChamado(os.getOsId());
			validaRowDeRespostaChamado();
			
			
		}else {
			menssagemAviso("Impossivel abrir o chamado                                                               Chamado ainda nao foi alocado para um analista.");
			
		}
	
	}

	/*
	public Interacao downloadAnexo() throws UnsupportedEncodingException {
		
		for (Interacao interacao : listaDeInteracao) {
		
			 byte[] decodedBytes = Base64.getDecoder().decode(interacao.getAnexo());
			 download.setAnexo(new String(decodedBytes, "UTF_8"));
			
		}
		
		return this.download;
	
	} */
	
	public void gravarInteracao() {
		
		
	}
	
	

	public void validaRowDeRespostaChamado() {
		if(perfilUsuarioLogado != 1 && perfilUsuarioLogado != 3) {	
			if(osSelecionada.getStatusOs() == 4) {
				this.rowAnalista = false;
				this.rowUsuario = false;
				this.rowUsuarioTeste = true;	
			
			}else {
				this.rowAnalista = false;
				this.rowUsuario = true;
				this.rowUsuarioTeste = false;
			}
					
		}else {
			
			this.rowAnalista = true;
			this.rowUsuario = false;
			this.rowUsuarioTeste = false;
		}
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


	public boolean getRowAnalista() {
		return rowAnalista;
	}


	public void setRowAnalista(boolean rowAnalista) {
		this.rowAnalista = rowAnalista;
	}


	public boolean getRowUsuario() {
		return rowUsuario;
	}


	public void setRowUsuario(boolean rowUsuario) {
		this.rowUsuario = rowUsuario;
	}


	public boolean getRowUsuarioTeste() {
		return rowUsuarioTeste;
	}


	public void setRowUsuarioTeste(boolean rowUsuarioTeste) {
		this.rowUsuarioTeste = rowUsuarioTeste;
	}


	public Interacao getDownload() {
		return download;
	}


	public void setDownload(Interacao download) {
		this.download = download;
	}

}
