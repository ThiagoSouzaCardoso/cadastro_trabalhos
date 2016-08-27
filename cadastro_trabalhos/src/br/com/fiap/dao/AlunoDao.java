package br.com.fiap.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import br.com.fiap.model.Aluno;
import br.com.fiap.util.JPAUtil;

public class AlunoDao extends GenericDao<Aluno> implements Dao<Aluno> {

	public AlunoDao() {
		super(Aluno.class);
	}


}
