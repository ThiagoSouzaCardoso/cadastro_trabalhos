package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.model.Curso;

@ManagedBean
@RequestScoped
public class CursoMB {

	private Curso curso;
	private boolean ativaBotao = true;
	CursoDao dao = new CursoDao();
	EscolaDao escolaDao = new EscolaDao();

	public CursoMB() {
		if (escolaDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}

	public void gravar() {
		System.out.println(curso.getNomeCurso());
		dao.adicionar(curso);
	}

	public void limpar() {
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public boolean isAtivaBotao() {
		return ativaBotao;
	}

	public void setAtivaBotao(boolean ativaBotao) {
		this.ativaBotao = ativaBotao;
	}

}
