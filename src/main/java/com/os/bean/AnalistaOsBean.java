package com.os.bean;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.junit.Test;

import com.os.dao.AlocaOsDao;
import com.os.dao.AnalistaOsDao;
import com.os.generico.GenericBean;
import com.os.model.OsChamado;



@ManagedBean
@ViewScoped
public class AnalistaOsBean extends GenericBean{
	
	
	private BigInteger quantidadeChamadosParaAlocar;
	private List<OsChamado> listaChamadoDesenvolvimento;
	private List<OsChamado> listaChamadoTeste;
	private List<OsChamado> listaChamadoAguardandoUsuario;
	private List<OsChamado> listaChamadoAguardandoTerceiro;
	private String usuarioLogado;
	

	
	@PostConstruct
	public void init() {
		
		
		usuarioLogado = buscaUsuarioSessao().getUsuNome();
		quantidadeChamadosParaAlocar = new AlocaOsDao().buscarQuantidadeDeChamadosParaAlocar();
		listaChamadoDesenvolvimento = new AnalistaOsDao().buscarChamadosEmDesenvolvimento(usuarioLogado);
		listaChamadoTeste = new AnalistaOsDao().buscarChamadosEmTeste(usuarioLogado);
		listaChamadoAguardandoUsuario = new AnalistaOsDao().buscarChamadosAguardandoUsuarios(usuarioLogado);
	 	listaChamadoAguardandoTerceiro = new AnalistaOsDao().buscarChamadosAguardandoTerceiros(usuarioLogado);

	}
	

	
	public void redirecionarPaginasParaAlocar() {
		redirecionarPagina("os-alocar.xhtml"); 
	}
	
	public void redirecionarPaginasParaPesquisarOs() {
		redirecionarPagina("os-pesquisar.xhtml"); 
	}

	
	
	// GATTERS AND SETTERS
	public BigInteger getQuantidadeChamadosParaAlocar() {
		return quantidadeChamadosParaAlocar;
	}

	public void setQuantidadeChamadosParaAlocar(BigInteger quantidadeChamadosParaAlocar) {
		this.quantidadeChamadosParaAlocar = quantidadeChamadosParaAlocar;
	}

	public List<OsChamado> getListaChamadoDesenvolvimento() {
		return listaChamadoDesenvolvimento;
	}

	public void setListaChamadoDesenvolvimento(List<OsChamado> listaChamadoDesenvolvimento) {
		this.listaChamadoDesenvolvimento = listaChamadoDesenvolvimento;
	}

	public List<OsChamado> getListaChamadoTeste() {
		return listaChamadoTeste;
	}

	public void setListaChamadoTeste(List<OsChamado> listaChamadoTeste) {
		this.listaChamadoTeste = listaChamadoTeste;
	}

	public List<OsChamado> getListaChamadoAguardandoUsuario() {
		return listaChamadoAguardandoUsuario;
	}

	public void setListaChamadoAguardandoUsuario(List<OsChamado> listaChamadoAguardandoUsuario) {
		this.listaChamadoAguardandoUsuario = listaChamadoAguardandoUsuario;
	}

	public List<OsChamado> getListaChamadoAguardandoTerceiro() {
		return listaChamadoAguardandoTerceiro;
	}

	public void setListaChamadoAguardandoTerceiro(List<OsChamado> listaChamadoAguardandoTerceiro) {
		this.listaChamadoAguardandoTerceiro = listaChamadoAguardandoTerceiro;
	}








	public String getUsuarioLogado() {
		return usuarioLogado;
	}








	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
