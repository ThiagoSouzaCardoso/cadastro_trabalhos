package br.com.fiap.dao;

import br.com.fiap.model.Escola;

public class EscolaDao extends GenericDao<Escola> implements Dao<Escola> {

	public EscolaDao() {
		super(Escola.class);
	}

}
