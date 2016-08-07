package br.com.fiap.dao;

import br.com.fiap.model.Professor;

public class ProfessorDao extends GenericDao<Professor> implements Dao<Professor> {

	public ProfessorDao() {
		super(Professor.class);
	}

}
