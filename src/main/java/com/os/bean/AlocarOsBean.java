package com.os.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces.Ajax;

import com.os.dao.AlocaOsDao;
import com.os.dao.UsuarioDao;
import com.os.generico.GenericBean;
import com.os.model.OsChamado;
import com.os.model.Usuario;

@ManagedBean
@ViewScoped
public class AlocarOsBean  extends GenericBean{

	private Integer tipo;
	private List<OsChamado> listaChamado;
	private List<Usuario> listaDeAnalistas;
	private OsChamado chamadoSelecionado;
	
	
	
	@PostConstruct
	public void init() {
			
		chamadoSelecionado = new OsChamado();
		listaChamado = new AlocaOsDao().buscarChamadosParaAlocar();
		listaDeAnalistas = new UsuarioDao().buscarUsuariosAnalistas();
		
	}
	
	
	
	public void selecionaChamado(OsChamado os) {
 		this.chamadoSelecionado = os;	
	}
	
	
	public void redirecionarPaginasParaPesquisarOs() {
		redirecionarPagina("os-pesquisar.xhtml"); 
	}

	
	// GATTERS AND SETTERS
	public Integer getTipo() {
		return tipo;
	}



	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}



	public List<OsChamado> getListaChamado() {
		return listaChamado;
	}



	public void setListaChamado(List<OsChamado> listaChamado) {
		this.listaChamado = listaChamado;
	}



	public List<Usuario> getListaDeAnalistas() {
		return listaDeAnalistas;
	}



	public void setListaDeAnalistas(List<Usuario> listaDeAnalistas) {
		this.listaDeAnalistas = listaDeAnalistas;
	}



	public OsChamado getChamadoSelecionado() {
		return chamadoSelecionado;
	}



	public void setChamadoSelecionado(OsChamado chamadoSelecionado) {
		this.chamadoSelecionado = chamadoSelecionado;
	}


	
	
}
