package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

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

	private List<Curso> selectCurso = new ArrayList<>();
	private List<Escola> selectEscola = new ArrayList<>();
	private List<Disciplina> selectDisciplina = new ArrayList<>();

	public AlunoMB() {
	}
	
	
	@PostConstruct
	public void init(){
		aluno = new Aluno();
		selectEscola  = escolaDao.listar();
		
		if (cursoDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}
	
	public void selecionarEscola(AjaxBehaviorEvent ev) {
		javax.faces.component.html.HtmlSelectOneMenu html = (javax.faces.component.html.HtmlSelectOneMenu) ev.getSource();
		Escola escola = (Escola)html.getValue();
		selectCurso = escola.getCursos();
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

	public List<Curso> getSelectCurso() {
		return selectCurso;
	}

	public void setSelectCurso(List<Curso> selectCurso) {
		this.selectCurso = selectCurso;
	}

	public List<Escola> getSelectEscola() {
		return selectEscola;
	}

	public void setSelectEscola(List<Escola> selectEscola) {
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

	public List<Disciplina> getSelectDisciplina() {
		return selectDisciplina;
	}

	public void setSelectDisciplina(List<Disciplina> selectDisciplina) {
		this.selectDisciplina = selectDisciplina;
	}
	
	

}
