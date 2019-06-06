package com.os.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	private String responsavel;
	private Date dataPrevisao;
	
	
	@PostConstruct
	public void init() {
		
		chamadoSelecionado= new OsChamado();
		listaChamado = new AlocaOsDao().buscarChamadosParaAlocar();
		listaDeAnalistas = new UsuarioDao().buscarUsuariosAnalistas();
		
	}

	
	public void alocarChamado() {
		
		if(validaChamado()){
		
			String analista = new AlocaOsDao().bucarAnalistaParaAlocar(responsavel);
			
			if(analista != null ) {
				
				if(new AlocaOsDao().alocarChamados(chamadoSelecionado.getOsId(), tipo, analista, dataPrevisao)) {
					redirecionarPagina("os-alocar.xhtml");
				
			}else {
				
				menssagemErro("Responsavel nulo");
			}
			
			
			
			
			}else {
				menssagemErro("Erro ao alocar o chamado.");
			}
		}
		
	}
	
	

	
	@SuppressWarnings("unused")
	public boolean validaChamado() {
		
		if(chamadoSelecionado.getOsId() != null) {		
			if(tipo != null) {
				if( responsavel != null || !responsavel.isEmpty() ) {
					if(dataPrevisao != null) {
						return true;
					}else {
						menssagemAviso("Favor selecionar uma data de entrega.");
						return false;
					}
				}else {
					menssagemAviso("Favor selecionar um responsavel.");
					return false;
				}

			}else {
				menssagemAviso("Favor selecionar o tipo do chamado.");
				return false;
			}

		}else {
			menssagemErro("Chamado Não Encontrado");
			return false;
		}	
	}
	
	
	public void selecionaChamado(OsChamado os) {
		this.chamadoSelecionado = os;	
	}
	
	
	public void redirecionarPaginasParaPesquisarOs() {
		redirecionarPagina("os-pesquisar.xhtml"); 
	}

	
	// GATTERS AND SETTERS

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
		System.out.println(chamadoSelecionado.getTituloOs());;
		return chamadoSelecionado;
	}



	public void setChamadoSelecionado(OsChamado chamadoSelecionado) {
		this.chamadoSelecionado = chamadoSelecionado;
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public Date getDataPrevisao() {
		return dataPrevisao;
	}


	public void setDataPrevisao(Date dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}


	
}
