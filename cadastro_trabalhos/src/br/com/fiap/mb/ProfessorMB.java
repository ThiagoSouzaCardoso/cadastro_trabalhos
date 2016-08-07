package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.ProfessorDao;
import br.com.fiap.model.Professor;

@ManagedBean
@RequestScoped
public class ProfessorMB {

	private Professor professor;
	ProfessorDao dao = new ProfessorDao();
	
	public ProfessorMB() {
		// TODO Auto-generated constructor stub
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
	
	
	
	
}
