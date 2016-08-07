package br.com.fiap.dao;

import br.com.fiap.model.Trabalho;

public class TrabalhoDao extends GenericDao<Trabalho> implements Dao<Trabalho> {

	public TrabalhoDao() {
		super(Trabalho.class);
	}

}
