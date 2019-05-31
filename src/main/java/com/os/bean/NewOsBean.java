package com.os.bean;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import com.os.dao.NewOsDao;
import com.os.generico.GenericBean;
import com.os.model.OsChamado;



@ManagedBean
@ViewScoped
public class NewOsBean extends GenericBean {

	
	private String titulo;
	private String descricao;
	private UploadedFile upload;
	private Integer idUsuarioLogado;
	private String nomeUsuarioLogado;
	private String fileBlob;
	private List<OsChamado> listaChamado;
	 
	
	
	
	@PostConstruct
	public void init() {
	
		idUsuarioLogado = buscaUsuarioSessao().getUsuId();
		nomeUsuarioLogado = buscaUsuarioSessao().getUsuNome();
		listaChamado = new NewOsDao().buscarChamadoDoUsuario(nomeUsuarioLogado);
		
		
	}
	
	public void insereChamado() throws IOException {

		verificaSePossuiAnexo();
		if(validaCampos()) {
			
			if(new NewOsDao().insereChamado(titulo, descricao, nomeUsuarioLogado, fileBlob,idUsuarioLogado)) {
				menssagemSucesso("Chamado cadastrado com sucesso!");
			}else {
				menssagemErro("Erro ao cadastrar o chamado");
			}
				
		}	
		
	}
	
	
	@SuppressWarnings("unused")
	public void verificaSePossuiAnexo() throws IOException {
		
		if(upload != null) {
				
			String nomeArquivo = upload.getFileName();
			String formatoArquivo = upload.getContentType();
			byte[] file = new byte[(int) upload.getSize()];
	
			upload.getInputstream().read(file);
			this.setFileBlob(Base64.getEncoder().encodeToString(file));		
		}
	}
	
	public boolean validaCampos() {
		
		if((titulo == null || titulo.isEmpty()) && (descricao.isEmpty() || descricao == null)) {
			menssagemAviso("Favor preencher todas informações.");
			return false;
		
		}else {
			
			if(titulo != null || !titulo.isEmpty()) {
				if(descricao != null || !descricao.isEmpty()) {
					return true;
				
				}else {
					menssagemAviso("A Descrição é Obrigatoria.");
					return false;
				}
			
			}else {
				menssagemAviso("O Titulo é Obrigatorio.");
				return false;
			}
		}
	}
			
						

	
	
	// GATTERS AND SETTERS 
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UploadedFile getUpload() {
		return upload;
	}

	public void setUpload(UploadedFile upload) {
		this.upload = upload;
	}
	public Integer getIdUsuarioLogado() {
		return idUsuarioLogado;
	}

	public void setIdUsuarioLogado(Integer idUsuarioLogado) {
		this.idUsuarioLogado = idUsuarioLogado;
	}

	public String getFileBlob() {
		return fileBlob;
	}

	public void setFileBlob(String fileBlob) {
		this.fileBlob = fileBlob;
	}

	public List<OsChamado> getListaChamado() {
		return listaChamado;
	}

	public void setListaChamado(List<OsChamado> listaChamado) {
		this.listaChamado = listaChamado;
	}

}
