package com.os.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.os.generico.GenericDao;
import com.os.model.OsChamado;

public class AlocaOsDao extends GenericDao<OsChamado>{

	
	@SuppressWarnings("unchecked")
	public List<OsChamado> buscarChamadosParaAlocar(){
		List<OsChamado> lista = new ArrayList<>();
		List<Object> listaObjeto = null;
		EntityManager em = getEntityManager();
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(" select  ");
			sb.append(" os_id ");
			sb.append(" ,os_titulo ");
			sb.append(" ,os_data ");
			sb.append(" ,os_descricao ");

			sb.append(" from ");
			sb.append(" os_chamado ");

			sb.append(" where ");
			sb.append(" os_analista is null ");
			sb.append(" and os_dataprevisao is null ");
			sb.append(" and os_tipo is null ");
			
			Query query = em.createNativeQuery(sb.toString());
			listaObjeto = query.getResultList();
			
			for (int i = 0; i < listaObjeto.size(); i++) {
				Object[] result = (Object[]) listaObjeto.get(i);
				
				OsChamado model = new OsChamado();
				
				model.setOsId((Integer) result[0]);
				model.setTituloOs((String) result[1]);
				model.setDataOs((Date) result[2]);
				model.setDescricaoOs((String) result[3]);

				lista.add(model);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			em.close();
		}
		
		return lista;
	}
	
	
	
	public boolean alocarChamados(Integer id, Integer tipo, String responsavel, Date data) {
		
		EntityManager em = getEntityManager();
	
		try {
			
			String sql  = "update os_chamado set os_tipo = :tipo, os_analista = :responsavel, os_dataprevisao = :data where os_id = :id ";
			em.getTransaction().begin();
			Query query = em.createNativeQuery(sql);
			query.setParameter("tipo", tipo);
			query.setParameter("responsavel", responsavel);
			query.setParameter("data", data);
			query.setParameter("id", id);
			query.executeUpdate();
			em.getTransaction().commit();
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();
		}	
		
	}
	
	

	public BigInteger buscarQuantidadeDeChamadosParaAlocar(){
		
		BigInteger valor = null;

		EntityManager em = getEntityManager();
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(" select  ");
			sb.append(" count(os_id) ");

			sb.append(" from ");
			sb.append(" os_chamado ");

			sb.append(" where ");
			sb.append(" os_analista is null ");
			sb.append(" and os_dataprevisao is null ");
			sb.append(" and os_tipo is null ");
			
			Query query = em.createNativeQuery(sb.toString());
			valor = (BigInteger) query.getSingleResult();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			em.close();
		}
		
		return valor;
	}
	
	
}
