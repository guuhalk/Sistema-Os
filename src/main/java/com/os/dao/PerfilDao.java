package com.os.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.os.generico.GenericDao;
import com.os.model.Perfil;

public class PerfilDao extends GenericDao<Perfil> {
	
	
	@SuppressWarnings("unchecked")
	public List<Perfil> buscarTodosPerfils() {
		List<Perfil> lista = new ArrayList<>();
		List<Object> listaObjeto = null;
		EntityManager em = getEntityManager();
		
		try {
			StringBuilder sb = new StringBuilder();
			
			sb.append(" SELECT DISTINCT PRF_ID,PRF_ATIVO,PRF_DESCRICAO FROM ACE_PERFIL ");
			
			Query query = em.createNativeQuery(sb.toString());
			
			listaObjeto = query.getResultList();
			
			for (int i = 0; i < listaObjeto.size(); i++) {
				Object[] result = (Object[]) listaObjeto.get(i);
				
				Perfil model = new Perfil();
				model.setPrfId((Integer)result[0]);
				model.setPrfAtivo((Integer)result[1]);
				model.setPrfDescricao((String)result[2]);
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

}
