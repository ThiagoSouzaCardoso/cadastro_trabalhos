package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.model.Curso;

@ManagedBean
@RequestScoped
public class CursoMB {

	private Curso curso;
	CursoDao dao = new CursoDao();
	
	public CursoMB() {

	}
	
	public void gravar(){
		System.out.println(curso.getNomeCurso());
		dao.adicionar(curso);
	}
	
	public void limpar(){
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
