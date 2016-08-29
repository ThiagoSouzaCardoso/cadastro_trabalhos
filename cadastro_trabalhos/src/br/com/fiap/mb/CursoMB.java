package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.model.Curso;
import br.com.fiap.model.Escola;

@ManagedBean
@RequestScoped
public class CursoMB {

	private Curso curso;
	private List<Escola> selectEscola = new ArrayList<Escola>();
	private Escola escolaSelecionada;
	private boolean ativaBotao = true;
	CursoDao dao = new CursoDao();
	EscolaDao escolaDao = new EscolaDao();

	public CursoMB() {
		
		curso = new Curso();
		selectEscola = escolaDao.listar();
		
		if (escolaDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}

	public void gravar() {		
		Escola escola = escolaSelecionada;
		escola.getCursos().add(curso);
		curso.getEscolas().add(escola);
		dao.adicionar(curso);
		curso = new Curso();
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

	public List<Escola> getSelectEscola() {
		return selectEscola;
	}

	public void setSelectEscola(List<Escola> selectEscola) {
		this.selectEscola = selectEscola;
	}

	public Escola getEscolaSelecionada() {
		return escolaSelecionada;
	}

	public void setEscolaSelecionada(Escola escolaSelecionada) {
		this.escolaSelecionada = escolaSelecionada;
	}
	
	

}
