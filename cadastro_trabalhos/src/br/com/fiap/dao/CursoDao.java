package br.com.fiap.dao;

import br.com.fiap.model.Curso;

public class CursoDao extends GenericDao<Curso> implements Dao<Curso> {

	public CursoDao() {
		super(Curso.class);
	}

}
