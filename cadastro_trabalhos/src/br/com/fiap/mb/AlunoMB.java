package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Curso;
import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Escola;

@ManagedBean
@SessionScoped
public class AlunoMB {

	private Aluno aluno;

	AlunoDao dao = new AlunoDao();
	private boolean ativaBotao = true;
	EscolaDao escolaDao = new EscolaDao();
	CursoDao cursoDao = new CursoDao();
	DisciplinaDao disciplinaDao = new DisciplinaDao();
	private int idEscolaSelecionada;
	private int idCursoSelecionado;

	private List<SelectItem> selectCurso = new ArrayList<>();
	private List<SelectItem> selectEscola = new ArrayList<>();
	private List<SelectItem> selectDisciplina = new ArrayList<>();

	public AlunoMB() {

		aluno = new Aluno();

		for (Escola escola : escolaDao.listar()) {
			selectEscola.add(new SelectItem(escola.getId(), escola.getNomeEscola()));
		}

		if (cursoDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}

	public void selecionaEscola(ValueChangeEvent event) {
		Escola escola = escolaDao.buscar((Integer)event.getNewValue());
		for (Curso curso : escola.getCursos()) {
			selectCurso.add(new SelectItem(curso.getId(), curso.getNomeCurso()));
		}
		escola.getAlunos().add(aluno);
		escolaDao.atualizar(escola);
		aluno.setEscola(escola);
	}

	public void selecionaCurso(ValueChangeEvent event) {
		Curso curso = cursoDao.buscar((Integer)event.getNewValue());
		curso.getAlunos().add(aluno);
		cursoDao.atualizar(curso);
		aluno.setCurso(curso);
		
		for (Disciplina disciplina : curso.getDisciplinas()) {
			selectDisciplina.add(new SelectItem(disciplina.getId(), disciplina.getNomeDisciplina()));
		}
		
	}
	
	public void selecionaDisciplina(ValueChangeEvent event) {
		Disciplina disciplina = disciplinaDao.buscar((Integer)event.getNewValue());
//		disciplina.getAlunos().add(aluno);
//		disciplinaDao.atualizar(disciplina);
//		aluno.getDisciplinas().add(disciplina);
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

	public int getIdEscolaSelecionada() {
		return idEscolaSelecionada;
	}

	public void setIdEscolaSelecionada(int idEscolaSelecionada) {
		this.idEscolaSelecionada = idEscolaSelecionada;
	}

	public int getIdCursoSelecionado() {
		return idCursoSelecionado;
	}

	public void setIdCursoSelecionado(int idCursoSelecionado) {
		this.idCursoSelecionado = idCursoSelecionado;
	}

	public List<SelectItem> getSelectDisciplina() {
		return selectDisciplina;
	}

	public void setSelectDisciplina(List<SelectItem> selectDisciplina) {
		this.selectDisciplina = selectDisciplina;
	}
	
	

}
