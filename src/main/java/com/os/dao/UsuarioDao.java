package com.os.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.os.generico.GenericDao;
import com.os.model.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	
	public Usuario buscarUsuarioParaLogin(String login , String senha) {
		//AceUsuario usuario = new AceUsuario();
		EntityManager em = getEntityManager();
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM usuario WHERE usu_login = :usu AND usu_senha = :senha");
			Query query = em.createNativeQuery(sb.toString(), Usuario.class);
			query.setParameter("usu", login);
			query.setParameter("senha", senha);
			return (Usuario) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			em.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodosUsuarios() {
		List<Usuario> lista = new ArrayList<>();
		List<Object> listaObjeto = null;
		EntityManager em = getEntityManager();
		
		try {
			StringBuilder sb = new StringBuilder();
			
			sb.append("select * from usuario; ");
			
			Query query = em.createNativeQuery(sb.toString());
			
			listaObjeto = query.getResultList();
			
			for (int i = 0; i < listaObjeto.size(); i++) {
				Object[] result = (Object[]) listaObjeto.get(i);
				
				Usuario model = new Usuario();
				model.setUsuId((Integer)result[0]);
				model.setUsuAtivo((Integer)result[1]);
				
				if(model.getUsuAtivo() == 1) {
					model.setStatus("Ativo");
				}else {
					model.setStatus("Inativo");
				}
				model.setUsuCpf((String)result[2]);
				model.setUsuEmail((String)result[3]);
				model.setUsuLogin((String)result[4]);
				model.setUsuNome((String)result[5]);
				
				lista.add(model);
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			em.close();
		}

		return lista;
	
	}
	

	public Usuario cadastroDeUsuario(String nome , String login, String senha, String email, 
			String cpf, Integer status, Integer perfil) {
		
		Usuario usuario = new Usuario();
		EntityManager em = getEntityManager();
		
		try {
			StringBuilder sb = new StringBuilder();
			
			sb.append("INSERT INTO usuario VALUES (NULL,:status,:cpf,:email,:login,:nome,:senha,:perfil)");
			
			em.getTransaction().begin();
			Query query = em.createNativeQuery(sb.toString());
			query.setParameter("nome", nome);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			query.setParameter("email", email);
			query.setParameter("cpf", cpf);
			query.setParameter("status", status);
			query.setParameter("perfil", perfil);
			
			query.executeUpdate();
			
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		}finally {
			em.close();
		}

		return usuario;
	
	}
	
	
	@Test
	public void criarTabelas() {
		
		EntityManager em = getEntityManager();
		em.close();
	}
	
	

}

