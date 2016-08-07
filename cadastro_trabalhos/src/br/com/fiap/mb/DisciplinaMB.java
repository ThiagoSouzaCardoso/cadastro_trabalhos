package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.model.Disciplina;

@ManagedBean
@RequestScoped
public class DisciplinaMB {

	private Disciplina disciplina;
	DisciplinaDao dao = new DisciplinaDao();

	public DisciplinaMB() {
		// TODO Auto-generated constructor stub
	}

	public void gravar() {
		dao.adicionar(disciplina);
	}

	public void limpar() {

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
