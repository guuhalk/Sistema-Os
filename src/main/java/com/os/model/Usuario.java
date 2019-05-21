package com.os.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name="Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id", nullable=false)
	private Integer usuId;
	
	@Column(name="usu_login", nullable=false)
	private String  usuLogin;
	
	@Column(name="usu_nome", nullable=false)
	private String  usuNome;
	
	@Column(name="usu_senha", nullable=false)
	private String  usuSenha;
	
	@Column(name="usu_email")
	private String  usuEmail;
	
	@Column(name="usu_cpf", nullable=false)
	private String  usuCpf;
	
	@Column(name="usu_ativo", nullable=false)
	private Integer usuAtivo;

	@OneToOne
	@JoinColumn(name="prf_id")
	private Perfil prfId;
	
	@Transient
	private String status;

	
	public Usuario() {
		
	}

	// GATTERS AND SETTERS
	public Integer getUsuId() {
		return usuId;
	}

	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}

	public String getUsuLogin() {
		return usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuNome() {
		return usuNome;
	}

	public void setUsuNome(String usuNome) {
		this.usuNome = usuNome;
	}

	public String getUsuSenha() {
		return usuSenha;
	}

	public void setUsuSenha(String usuSenha) {
		this.usuSenha = usuSenha;
	}

	public String getUsuEmail() {
		return usuEmail;
	}

	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}

	public String getUsuCpf() {
		return usuCpf;
	}

	public void setUsuCpf(String usuCpf) {
		this.usuCpf = usuCpf;
	}

	public Integer getUsuAtivo() {		
		return usuAtivo;
	}

	public void setUsuAtivo(Integer usuAtivo) {
		this.usuAtivo = usuAtivo;
	}

	public Perfil getPrfId() {
		return prfId;
	}

	public void setPrfId(Perfil prfId) {
		this.prfId = prfId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	
}