package br.com.fiap.dao;

import br.com.fiap.model.Disciplina;

public class DisciplinaDao extends GenericDao<Disciplina> implements Dao<Disciplina> {

	public DisciplinaDao() {
		super(Disciplina.class);
	}

}
