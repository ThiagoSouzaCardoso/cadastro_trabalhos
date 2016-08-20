package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Curso;
import br.com.fiap.model.Escola;

@ManagedBean
@RequestScoped
public class AlunoMB {

	private Aluno aluno;

	AlunoDao dao = new AlunoDao();
	private boolean ativaBotao = true;
	EscolaDao escolaDao = new EscolaDao();
	CursoDao cursoDao = new CursoDao();

	private List<SelectItem> selectCurso = new ArrayList<>();
	private List<SelectItem> selectEscola = new ArrayList<>();

	public AlunoMB() {
		for (Escola escola : escolaDao.listar()) {
			selectEscola.add(new SelectItem(escola.getId(), escola.getNomeEscola()));
		}

		for (Curso curso : cursoDao.listar()) {
			selectCurso.add(new SelectItem(curso.getId(), curso.getNomeCurso()));
		}

		if (cursoDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}

	public void gravar() {
		dao.adicionar(aluno);
	}

	public void limpar() {

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<SelectItem> getSelectCurso() {
		return selectCurso;
	}

	public void setSelectCurso(List<SelectItem> selectCurso) {
		this.selectCurso = selectCurso;
	}

	public List<SelectItem> getSelectEscola() {
		return selectEscola;
	}

	public void setSelectEscola(List<SelectItem> selectEscola) {
		this.selectEscola = selectEscola;
	}

	public boolean isAtivaBotao() {
		return ativaBotao;
	}

	public void setAtivaBotao(boolean ativaBotao) {
		this.ativaBotao = ativaBotao;
	}

}
