package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Curso;
import br.com.fiap.model.Escola;

@ManagedBean
@RequestScoped
public class CursoMB {

	private Curso curso;
	private List<SelectItem> selectEscola = new ArrayList<SelectItem>();
	private int escolaSelecionada;
	private boolean ativaBotao = true;
	CursoDao dao = new CursoDao();
	EscolaDao escolaDao = new EscolaDao();

	public CursoMB() {
		
		curso = new Curso();
		
		for(Escola escola:escolaDao.listar()){
			selectEscola.add(new SelectItem(escola.getId(), escola.getNomeEscola()));
		}
		
		if (escolaDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}

	public void gravar() {		
		Escola escola = escolaDao.buscar(escolaSelecionada);
		curso.getEscolas().add(escola);
		System.out.println(curso.getNomeCurso() + "na escola " + escola.getNomeEscola());
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

	public List<SelectItem> getSelectEscola() {
		return selectEscola;
	}

	public void setSelectEscola(List<SelectItem> selectEscola) {
		this.selectEscola = selectEscola;
	}

	public int getEscolaSelecionada() {
		return escolaSelecionada;
	}

	public void setEscolaSelecionada(int escolaSelecionada) {
		this.escolaSelecionada = escolaSelecionada;
	}
	
	

}
