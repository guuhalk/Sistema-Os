package com.os.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.os.generico.GenericDao;
import com.os.model.Interacao;
import com.os.model.OsChamado;

public class InteracaoOsDao extends GenericDao<OsChamado> {

	@SuppressWarnings("unchecked")
	public List<OsChamado> buscarChamadoDoUsuario(Integer  idOs){
		List<OsChamado> lista = new ArrayList<>();
		List<Object> listaObjeto = null;
		EntityManager em = getEntityManager();
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append(" select os_id,os_status,os_data,os_tipo,os_titulo,os_usuabertura,os_analista,os_descricao,os_dataprevisao ");
			sb.append(" from os_chamado where os_id = :idOs ");
			
			Query query = em.createNativeQuery(sb.toString());
			query.setParameter("idOs", idOs);
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
				model.setAnalistaOs((String) result[6]);
				model.setDescricaoOs((String) result[7]);
				model.setDataPrevisaoOs((Date) result[8]);
				
				lista.add(model);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			em.close();
		}
		
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Interacao> buscarInteracaoDoChamado (Integer  idOs){
		List<Interacao> lista = new ArrayList<>();
		List<Object> listaObjeto = null;
		EntityManager em = getEntityManager();
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(" SELECT ");
			sb.append(" os_interacao.in_id ");
			sb.append(" ,os_interacao.os_id ");
			sb.append(" ,os_interacao.usu_id ");
			sb.append(" ,os_interacao.in_data ");
			sb.append(" ,os_interacao.in_descricao ");
			sb.append(" ,os_interacao.in_anexo ");
			sb.append(" ,usuario.usu_nome ");

			sb.append(" FROM ");
			sb.append(" os_interacao ");
			sb.append(" JOIN usuario ON (usuario.usu_id = os_interacao.usu_id) ");

			sb.append(" WHERE ");
			sb.append(" os_id = :idOs ");
			sb.append(" and os_interacao.in_descricao <> ''  ");
			sb.append(" ORDER BY in_data; ");
			
			Query query = em.createNativeQuery(sb.toString());
			query.setParameter("idOs", idOs);
			listaObjeto = query.getResultList();
			
			for (int i = 0; i < listaObjeto.size(); i++) {
				Object[] result = (Object[]) listaObjeto.get(i);
				
				Interacao model = new Interacao();
				
				model.setInId((Integer)       result[0]);
				model.setOsId((Integer)       result[1]);
				model.setUsuId((Integer)      result[2]);
				model.setInData((Date)        result[3]);
				model.setInDescricao((String) result[4]);
				model.setAnexo((String)       result[5]);
				model.setNomeUsuario((String) result[6]);
				
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
