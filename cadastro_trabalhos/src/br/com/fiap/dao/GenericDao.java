package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.util.JPAUtil;

public class GenericDao<T> implements Dao<T>{

		private final Class<T> classe;
		protected EntityManager em;

		public GenericDao(Class<T> classe) {
			this.classe = classe;
		}

		@Override
		public void adicionar(T entidade) {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
			em.close();

		}

		@Override
		public List<T> listar() {
			em = JPAUtil.getEntityManager();
			return em.createQuery("From " + classe.getSimpleName()).getResultList();
		}

		@Override
		public T buscar(int id) {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			T entidade = em.find(classe, id);
			em.getTransaction().commit();
			em.close();

			return entidade;
		}
		
		@Override
		public T atualizar(T entidade) {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			T t = em.merge(entidade);
			em.getTransaction().commit();
			em.close();
			
			return t;
	}

		@Override
		public boolean exiteDados() {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			int i = em.createQuery("From " + classe.getSimpleName()).getResultList().size();
			em.getTransaction().commit();
			em.close();
			return i>0?true:false;
		} 
	
}
