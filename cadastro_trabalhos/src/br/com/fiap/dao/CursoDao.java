package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.model.Curso;
import br.com.fiap.util.JPAUtil;

public class CursoDao extends GenericDao<Curso> implements Dao<Curso> {

	public CursoDao() {
		super(Curso.class);
	}

}
