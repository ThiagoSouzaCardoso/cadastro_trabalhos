package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.model.Curso;
import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Escola;

@ManagedBean
@RequestScoped
public class DisciplinaMB {

	private Disciplina disciplina;
	private List<SelectItem> selectCurso = new ArrayList<SelectItem>();
	private int cursoSelecionada;
	private boolean ativaBotao = true;
	DisciplinaDao dao = new DisciplinaDao();
	CursoDao cursoDao = new CursoDao();

	public DisciplinaMB() {
		
		disciplina = new Disciplina();
		
		for(Curso curso:cursoDao.listar()){
			selectCurso.add(new SelectItem(curso.getId(), curso.getNomeCurso()));
		}
		
		
		if(cursoDao.exiteDados()){
			ativaBotao = true;
		}else{
			ativaBotao = false;
		}
	}

	public void gravar() {
		Curso escola = cursoDao.buscar(cursoSelecionada);
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

	

	public List<SelectItem> getSelectCurso() {
		return selectCurso;
	}

	public void setSelectCurso(List<SelectItem> selectCurso) {
		this.selectCurso = selectCurso;
	}

	public int getCursoSelecionada() {
		return cursoSelecionada;
	}

	public void setCursoSelecionada(int cursoSelecionada) {
		this.cursoSelecionada = cursoSelecionada;
	}

	

}
