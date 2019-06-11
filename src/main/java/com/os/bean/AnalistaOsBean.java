package com.os.bean;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.os.dao.AlocaOsDao;
import com.os.dao.AnalistaOsDao;
import com.os.generico.GenericBean;
import com.os.model.OsChamado;



@ManagedBean
@ViewScoped
public class AnalistaOsBean extends GenericBean{
	
	// CONTADORES
	private BigInteger quantidadeChamadosParaAlocar;
	private BigInteger quantidadeChamadosDesenvolvimento;
	private BigInteger quantidadeChamadosAguardandoUsuario;
	private BigInteger quantidadeChamadosAguardandoTerceiros;
	private BigInteger quantidadeChamadosTeste;
	
	// VALIDAÇÕES
	private boolean rotinaDesenvolvimento;
	private boolean rotinaAguardandoUsuario;
	private boolean rotinaAguardandoTerceiros;
	private boolean rotinateste;
	
	
	private List<OsChamado> listaChamadoDesenvolvimento;
	private List<OsChamado> listaChamadoTeste;
	private List<OsChamado> listaChamadoAguardandoUsuario;
	private List<OsChamado> listaChamadoAguardandoTerceiro;
	private String usuarioLogado;
	

	
	
	
	@PostConstruct
	public void init() {
		
		
		usuarioLogado = buscaUsuarioSessao().getUsuNome();
		quantidadeChamadosParaAlocar = new AlocaOsDao().buscarQuantidadeDeChamadosParaAlocar();
		quantidadeChamadosDesenvolvimento = new AnalistaOsDao().buscarQuantidadeDeChamadosEmDesenvolvimento();
		quantidadeChamadosAguardandoUsuario = new AnalistaOsDao().buscarQuantidadeDeChamadosAguardandoUsuario();
		quantidadeChamadosAguardandoTerceiros = new AnalistaOsDao().buscarQuantidadeDeChamadosAguardandoTerceiros();
		quantidadeChamadosTeste = new AnalistaOsDao().buscarQuantidadeDeChamadosEmTeste();	
		listaChamadoDesenvolvimento = new AnalistaOsDao().buscarChamadosEmDesenvolvimento(usuarioLogado);
		listaChamadoTeste = new AnalistaOsDao().buscarChamadosEmTeste(usuarioLogado);
		listaChamadoAguardandoUsuario = new AnalistaOsDao().buscarChamadosAguardandoUsuarios(usuarioLogado);
	 	listaChamadoAguardandoTerceiro = new AnalistaOsDao().buscarChamadosAguardandoTerceiros(usuarioLogado);
	 	validaDesenvolvimento();

	}
	

	
	public void redirecionarPaginasParaAlocar() {
		redirecionarPagina("os-alocar.xhtml"); 
	}
	
	public void redirecionarPaginasParaPesquisarOs() {
		redirecionarPagina("os-pesquisar.xhtml"); 
	}

	
	
	// METODOS DE VALIDAÇÕES DE MENU 
	public void validaDesenvolvimento() {
		rotinaDesenvolvimento = true;
		rotinaAguardandoUsuario = false;
		rotinaAguardandoTerceiros = false;
		rotinateste= false;
	}
	public void validaAguardandoUsuario() {
		rotinaDesenvolvimento = false;
		rotinaAguardandoUsuario = true;
		rotinaAguardandoTerceiros = false;
		rotinateste= false;
	}
	public void validaAguardandoTerceiro() {
		rotinaDesenvolvimento = false;
		rotinaAguardandoUsuario = false;
		rotinaAguardandoTerceiros = true;
		rotinateste= false;
	}
	public void validaTeste() {
		rotinaDesenvolvimento = false;
		rotinaAguardandoUsuario = false;
		rotinaAguardandoTerceiros = false;
		rotinateste= true;
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

	public boolean isRotinaDesenvolvimento() {
		return rotinaDesenvolvimento;
	}

	public void setRotinaDesenvolvimento(boolean rotinaDesenvolvimento) {
		this.rotinaDesenvolvimento = rotinaDesenvolvimento;
	}

	public boolean isRotinaAguardandoUsuario() {
		return rotinaAguardandoUsuario;
	}

	public void setRotinaAguardandoUsuario(boolean rotinaAguardandoUsuario) {
		this.rotinaAguardandoUsuario = rotinaAguardandoUsuario;
	}

	public boolean isRotinaAguardandoTerceiros() {
		return rotinaAguardandoTerceiros;
	}
	
	public void setRotinaAguardandoTerceiros(boolean rotinaAguardandoTerceiros) {
		this.rotinaAguardandoTerceiros = rotinaAguardandoTerceiros;
	}

	public boolean isRotinateste() {
		return rotinateste;
	}

	public void setRotinateste(boolean rotinateste) {
		this.rotinateste = rotinateste;
	}

	public BigInteger getQuantidadeChamadosDesenvolvimento() {
		return quantidadeChamadosDesenvolvimento;
	}

	public void setQuantidadeChamadosDesenvolvimento(BigInteger quantidadeChamadosDesenvolvimento) {
		this.quantidadeChamadosDesenvolvimento = quantidadeChamadosDesenvolvimento;
	}

	public BigInteger getQuantidadeChamadosAguardandoUsuario() {
		return quantidadeChamadosAguardandoUsuario;
	}

	public void setQuantidadeChamadosAguardandoUsuario(BigInteger quantidadeChamadosAguardandoUsuario) {
		this.quantidadeChamadosAguardandoUsuario = quantidadeChamadosAguardandoUsuario;
	}

	public BigInteger getQuantidadeChamadosAguardandoTerceiros() {
		return quantidadeChamadosAguardandoTerceiros;
	}

	public void setQuantidadeChamadosAguardandoTerceiros(BigInteger quantidadeChamadosAguardandoTerceiros) {
		this.quantidadeChamadosAguardandoTerceiros = quantidadeChamadosAguardandoTerceiros;
	}

	public BigInteger getQuantidadeChamadosTeste() {
		return quantidadeChamadosTeste;
	}

	public void setQuantidadeChamadosTeste(BigInteger quantidadeChamadosTeste) {
		this.quantidadeChamadosTeste = quantidadeChamadosTeste;
	}	
	
}
