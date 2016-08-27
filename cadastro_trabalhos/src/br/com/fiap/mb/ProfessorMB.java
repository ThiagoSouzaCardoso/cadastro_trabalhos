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
	private List<SelectItem> selectEscola = new ArrayList<SelectItem>();
	private int escolaSelecionada;
	private boolean ativaBotao = true;
	ProfessorDao dao = new ProfessorDao();
	EscolaDao escolaDao = new EscolaDao();
	
	public ProfessorMB() {
		
		professor = new Professor();
		
		for(Escola escola:escolaDao.listar()){
			selectEscola.add(new SelectItem(escola.getId(), escola.getNomeEscola()));
		}
		
		if(escolaDao.exiteDados()){
			ativaBotao = true;
		}else{
			ativaBotao = false;
		}
	}
	
	public void gravar(){
		Escola escola = escolaDao.buscar(escolaSelecionada);
		dao.adicionar(professor);
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
