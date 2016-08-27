package br.com.fiap.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.util.JPAUtil;

public class UsuarioDao extends GenericDao<Usuario> implements Dao<Usuario>{

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public Usuario autenticacao(String login, String senha) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Usuario> createQuery = em.createQuery("from Usuario usuario where usuario.login = :pLogin and usuario.senha = :pSenha",Usuario.class);
		createQuery.setParameter("pLogin", login);
		createQuery.setParameter("pSenha", senha);
		Usuario usuario = null;
		try{
			usuario = createQuery.getSingleResult();
		}catch(NoResultException e){
			System.out.println("Nao foi encontrado");
		}
		em.getTransaction().commit();
		em.close();
		return usuario;
	}

}
