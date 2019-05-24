package com.os.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.os.dao.PerfilDao;
import com.os.dao.UsuarioDao;
import com.os.generico.GenericBean;
import com.os.model.Perfil;
import com.os.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean  extends GenericBean{

	
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String cpf;
	private Integer status;
	private boolean ativo;
	private Integer perfil;
	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	private List<Perfil> listaPerfil;
	private Usuario usuarioSelecionado;

	
	
	@PostConstruct
	public void init() {
		
		listaPerfil = new PerfilDao().buscarTodosPerfils();
		listaUsuarios = new UsuarioDao().buscarTodosUsuarios();
	
	}
	

	public void cadastrarUsuario() {

		if(validaCampos()) {
			new UsuarioDao().cadastroDeUsuario(nome, login, senha, email, cpf, status, perfil);
			menssagemSucesso("Usuario cadastrado com sucesso");
			limparCampos();
		}

	}

	public void limparCampos() {
		
		nome=""; login=""; email="";
		cpf=""; status=0; ativo=false;
		perfil=0;		
	}
	
	
	public boolean validaCampos() {
		
		if(nome != null && !nome.isEmpty()){
			if(login != null && !login.isEmpty()){
				if(senha != null && !senha.isEmpty()) {
					if(cpf != null && !cpf.isEmpty()) {
						if(perfil != 0 && perfil != null) {
							if(email != null && !email.isEmpty()) {
								if(ativo == false){
									status = 0;
									return true;
								}else {
									status = 1;
									return true;
								}
							}else {
								menssagemAviso("Favor Preencher um email.");
								return false;
							}
						}else {
							menssagemAviso("Favor selecionar um perfil.");
							return false;
						}	
					}else {
						menssagemAviso("Favor Preencher o cpf.");
						return false;
					}
				}else {
					menssagemAviso("Favor Preencher a senha.");	
					return false;
				}			
			}else {
				menssagemAviso("Favor Preencher o login.");
				return false;
			}
		}else {
			menssagemAviso("Favor Preencher o nome.");
			return false;
		}
		
	}
	
	 
	
	//GATTERS AND SETTERS
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}


	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getPerfil() {
		return perfil;
	}


	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}


	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
}
	