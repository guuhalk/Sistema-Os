package com.os.bean;

import java.util.Base64;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import com.os.generico.GenericBean;



@ManagedBean
@ViewScoped
public class NewOsBean extends GenericBean {

	
	private String titulo;
	private String descricao;
	private Integer tipo;
	private UploadedFile upload;
	
	
	
	@PostConstruct
	public void init() {
		
		
	}
	

	
	public void insereChamado() {

		
		
		if(upload != null) {
			
			String nomeArquivo = upload.getFileName();
			String formatoArquivo = upload.getContentType();
			byte[] file = new byte[(int) upload.getSize()];

			try {
					upload.getInputstream().read(file);
					String fileBlob = Base64.getEncoder().encodeToString(file);
			
			} catch (Exception e) {
				
			}
			//String testeDecod = new String(Base64.getDecoder().decode(testeEncond));
			
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
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public UploadedFile getUpload() {
		return upload;
	}
	public void setUpload(UploadedFile upload) {
		this.upload = upload;
	}	
}
