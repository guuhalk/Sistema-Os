package com.os.model;

import java.util.Date;

public class Interacao {
	
	
	private Integer inId;
	private Integer osId;
	private Integer usuId;
	private Date inData;
	private String inDescricao;
	private String anexo;
	private String nomeUsuario;
	private Integer perfilDoUsuarioInteracao;
	
	
	// GATTERS AND SETTERS
	public Integer getInId() {
		return inId;
	}
	public void setInId(Integer inId) {
		this.inId = inId;
	}
	public Integer getOsId() {
		return osId;
	}
	public void setOsId(Integer osId) {
		this.osId = osId;
	}
	public Integer getUsuId() {
		return usuId;
	}
	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}
	public Date getInData() {
		return inData;
	}
	public void setInData(Date inData) {
		this.inData = inData;
	}
	public String getInDescricao() {
		return inDescricao;
	}
	public void setInDescricao(String inDescricao) {
		this.inDescricao = inDescricao;
	}
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Integer getPerfilDoUsuarioInteracao() {
		return perfilDoUsuarioInteracao;
	}
	public void setPerfilDoUsuarioInteracao(Integer perfilDoUsuarioInteracao) {
		this.perfilDoUsuarioInteracao = perfilDoUsuarioInteracao;
	}

}
