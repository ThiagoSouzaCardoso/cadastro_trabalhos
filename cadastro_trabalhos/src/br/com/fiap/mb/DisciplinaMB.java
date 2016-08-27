package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.model.Disciplina;

@ManagedBean
@RequestScoped
public class DisciplinaMB {

	private Disciplina disciplina;
	private boolean ativaBotao = true;
	DisciplinaDao dao = new DisciplinaDao();
	CursoDao cursoDao = new CursoDao();

	public DisciplinaMB() {
		
		disciplina = new Disciplina();
		
		if(cursoDao.exiteDados()){
			ativaBotao = true;
		}else{
			ativaBotao = false;
		}
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

	public boolean isAtivaBotao() {
		return ativaBotao;
	}

	public void setAtivaBotao(boolean ativaBotao) {
		this.ativaBotao = ativaBotao;
	}

}
