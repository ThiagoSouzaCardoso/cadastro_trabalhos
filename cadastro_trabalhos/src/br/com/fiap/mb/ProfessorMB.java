package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.EscolaDao;
import br.com.fiap.dao.ProfessorDao;
import br.com.fiap.model.Professor;

@ManagedBean
@RequestScoped
public class ProfessorMB {

	private Professor professor;
	private boolean ativaBotao = true;
	ProfessorDao dao = new ProfessorDao();
	EscolaDao escolaDao = new EscolaDao();
	
	public ProfessorMB() {
		
		professor = new Professor();
		
		if(escolaDao.exiteDados()){
			ativaBotao = true;
		}else{
			ativaBotao = false;
		}
	}
	
	public void gravar(){
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
	
}
