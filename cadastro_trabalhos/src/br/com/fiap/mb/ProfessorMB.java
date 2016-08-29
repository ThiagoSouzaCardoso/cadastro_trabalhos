package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.EscolaDao;
import br.com.fiap.dao.ProfessorDao;
import br.com.fiap.model.Escola;
import br.com.fiap.model.Professor;

@ManagedBean
@RequestScoped
public class ProfessorMB {

	private Professor professor;
	private List<Escola> selectEscola = new ArrayList<Escola>();
	private Escola escolaSelecionada;
	private boolean ativaBotao = true;
	ProfessorDao dao = new ProfessorDao();
	EscolaDao escolaDao = new EscolaDao();
	
	public ProfessorMB() {
		professor = new Professor();
		selectEscola = escolaDao.listar();
		if(escolaDao.exiteDados()){
			ativaBotao = true;
		}else{
			ativaBotao = false;
		}
	}
	
	public void gravar(){
		professor.getEscolas().add(escolaSelecionada);
		escolaSelecionada.getProfessores().add(professor);
		dao.atualizar(professor);
		professor = new Professor();
	}
	
	public void limpar(){
		
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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
