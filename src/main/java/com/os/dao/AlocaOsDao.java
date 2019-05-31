package com.os.dao;

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

				lista.add(model);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			em.close();
		}
		
		return lista;
	}
	
	
	
	
}
