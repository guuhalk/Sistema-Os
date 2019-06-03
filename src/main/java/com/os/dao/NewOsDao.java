package com.os.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.os.generico.GenericDao;
import com.os.model.OsChamado;

public class NewOsDao extends GenericDao<OsChamado> {

	
	
	@SuppressWarnings("unchecked")
	public List<OsChamado> buscarChamadoDoUsuario(String usuario){
		List<OsChamado> lista = new ArrayList<>();
		List<Object> listaObjeto = null;
		EntityManager em = getEntityManager();
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("select os_id,os_status,os_data,os_tipo,os_titulo,os_usuabertura,os_descricao");
			sb.append(" from os_chamado where os_usuabertura = :usuario ");
			
			Query query = em.createNativeQuery(sb.toString());
			query.setParameter("usuario", usuario);
			listaObjeto = query.getResultList();
			
			for (int i = 0; i < listaObjeto.size(); i++) {
				Object[] result = (Object[]) listaObjeto.get(i);
				
				OsChamado model = new OsChamado();
				
				model.setOsId((Integer) result[0]);
				model.setStatusOs((Integer) result[1]);
				model.setDataOs((Date) result[2]);
				model.setTipoOs((Integer) result[3]);
				model.setTituloOs((String) result[4]);
				model.setUsuAberturaOs((String) result[5]);
				model.setDescricaoOs((String) result [6]);
				
				lista.add(model);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			em.close();
		}
		
		return lista;
	}
	
	

	
	public boolean insereChamado(String titulo, String descricao, String usuario, String anexo, Integer idUsuario ) {
		
		EntityManager em = getEntityManager();
		Integer os;
		
		try {
			
			String sql  = "insert into os_chamado values (null,1,now(),null,:titulo,:usuario,null,:descricao,null,null)";
			em.getTransaction().begin();
			Query query = em.createNativeQuery(sql);
			query.setParameter("titulo", titulo);
			query.setParameter("usuario", usuario);
			query.setParameter("descricao", descricao);
			query.executeUpdate();
			em.getTransaction().commit();
			
			sql = "select os_id from os_chamado where os_titulo = :titulo and os_descricao = :descricao and os_usuabertura = :usuario"; 
			query = em.createNativeQuery(sql);
			query.setParameter("titulo", titulo);
			query.setParameter("usuario", usuario);
			query.setParameter("descricao", descricao);
			os = (Integer) query.getSingleResult();
			
			sql  = "insert into os_interacao values (null,:os,:usuario,now(),null,:anexo)";
			em.getTransaction().begin();
			query = em.createNativeQuery(sql);
			query.setParameter("os", os);
			query.setParameter("usuario", idUsuario);
			query.setParameter("anexo", anexo);
			query.executeUpdate();
			em.getTransaction().commit();
			
		
		
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		
		return true;
	}
	
	
	
	
	
}
