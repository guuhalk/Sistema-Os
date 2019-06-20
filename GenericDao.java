package com.os.generico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class GenericDao<T> {

	private EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	

	
	public EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("os_db");
		}
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

	
	public boolean salvar(T registro) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(registro);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();
		}
	}
	
	public boolean delete (T registro) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(registro);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();
		}
	}
	
	public boolean update (T registro) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(registro);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.getMessage();
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();
		}
	}
	
	
}
