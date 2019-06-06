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
	private Date dataPrevisaoOs;
	private Date dataFechamento;
	
	
	private String statusFormatado;
	private String tipoFormatado; 
	private String corStatus;
	private Integer quantidadeDeChamadosParaAlocar;
		
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
	
	public String getStatusFormatado() {
		if(statusOs == 1) {
			this.statusFormatado = "Desenvolvimento";
		}
		
		if(statusOs == 2) {
			this.statusFormatado = "Aguardando Usuario";
		}
		
		if(statusOs == 3) {
			this.statusFormatado = "Aguardando Terceiros";
		}
		
		if(statusOs == 4) {
			this.statusFormatado = "Teste";
		}
		
		if(statusOs == 5) {
			this.statusFormatado = "Fechado";
		}
		
		if(statusOs == 6) {
			this.statusFormatado = "Reprovado";
		}

		return statusFormatado;
	}
	public void setStatusFormatado(String statusFormatado) {
		this.statusFormatado = statusFormatado;
	}
	public String getCorStatus() {

		if(statusOs == 1) {
			this.corStatus = "success";
		}
		
		if(statusOs == 2) {
			this.corStatus = "default";
		}
		
		if(statusOs == 3) {
			this.corStatus = "primary";
		}
		
		if(statusOs == 4) {
			this.corStatus = "warning";
		}
		
		if(statusOs == 5) {
			this.corStatus = "info";
		}
		
		if(statusOs == 6) {
			this.corStatus = "Danger";
		}
		
		return corStatus;
	}
	public void setCorStatus(String corStatus) {
		this.corStatus = corStatus;
	}
	public Date getDataPrevisaoOs() {
		return dataPrevisaoOs;
	}
	public void setDataPrevisaoOs(Date dataPrevisaoOs) {
		this.dataPrevisaoOs = dataPrevisaoOs;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Integer getQuantidadeDeChamadosParaAlocar() {
		return quantidadeDeChamadosParaAlocar;
	}
	public void setQuantidadeDeChamadosParaAlocar(Integer quantidadeDeChamadosParaAlocar) {
		this.quantidadeDeChamadosParaAlocar = quantidadeDeChamadosParaAlocar;
	}
	public String getTipoFormatado() {
		
		if(tipoOs == 1) {
			this.tipoFormatado = "Acesso";
		}
		
		if(tipoOs == 2) {
			this.tipoFormatado = "Manutenção";
		}		
		
		if(tipoOs == 3) {
			this.tipoFormatado = "Criação";
		}
		
		
		return tipoFormatado;
	}
	public void setTipoFormatado(String tipoFormatado) {
		this.tipoFormatado = tipoFormatado;
	}

}
