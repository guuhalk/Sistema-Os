package com.os.model;

import java.util.Date;

public class OsChamado {

	
	private Integer osId;
	private Integer statusOs;
	private Date dataOs;
	private Integer tipoOs;
	private String tituloOs;
	private String usuAberturaOs;
	private String analistaOs;
	private String descricaoOs;
	
	
	
	
	// GATTERS AND SETTERS 
	public Integer getOsId() {
		return osId;
	}
	public void setOsId(Integer osId) {
		this.osId = osId;
	}
	public Integer getStatusOs() {
		return statusOs;
	}
	public void setStatusOs(Integer statusOs) {
		this.statusOs = statusOs;
	}
	public Date getDataOs() {
		return dataOs;
	}
	public void setDataOs(Date dataOs) {
		this.dataOs = dataOs;
	}
	public Integer getTipoOs() {
		return tipoOs;
	}
	public void setTipoOs(Integer tipoOs) {
		this.tipoOs = tipoOs;
	}
	public String getTituloOs() {
		return tituloOs;
	}
	public void setTituloOs(String tituloOs) {
		this.tituloOs = tituloOs;
	}
	public String getUsuAberturaOs() {
		return usuAberturaOs;
	}
	public void setUsuAberturaOs(String usuAberturaOs) {
		this.usuAberturaOs = usuAberturaOs;
	}
	public String getAnalistaOs() {
		return analistaOs;
	}
	public void setAnalistaOs(String analistaOs) {
		this.analistaOs = analistaOs;
	}
	public String getDescricaoOs() {
		return descricaoOs;
	}
	public void setDescricaoOs(String descricaoOs) {
		this.descricaoOs = descricaoOs;
	}

}
