package br.com.fiap.dao;

import br.com.fiap.model.Aluno;

public class AlunoDao extends GenericDao<Aluno> implements Dao<Aluno> {

	public AlunoDao() {
		super(Aluno.class);
	}

}
