package br.com.fiap.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro_trabalhos");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}
