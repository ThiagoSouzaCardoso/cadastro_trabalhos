package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.dao.TrabalhoDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.AlunoTrabalho;
import br.com.fiap.model.Curso;
import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Escola;
import br.com.fiap.model.Trabalho;

@ManagedBean
@RequestScoped
public class NotasMB {

	private AlunoTrabalho alunoTrabalho;
	private List<SelectItem> selectAluno = new ArrayList<SelectItem>();
	private List<SelectItem> selectDisciplina = new ArrayList<SelectItem>();
	private List<SelectItem> selectTrabalho = new ArrayList<SelectItem>();

	AlunoDao alunoDao = new AlunoDao();
	TrabalhoDao trabalhoDao = new TrabalhoDao();
	DisciplinaDao disciplinaDao = new DisciplinaDao();
	
	public NotasMB() {
		for(Aluno aluno:alunoDao.listar()){
			selectAluno.add(new SelectItem(aluno.getId(), aluno.getNomeAluno()));
		}
		
		for(Disciplina disciplina:disciplinaDao.listar()){
			selectAluno.add(new SelectItem(disciplina.getId(), disciplina.getNomeDisciplina()));
		}
		
		for(Trabalho trabalho:trabalhoDao.listar()){
			selectAluno.add(new SelectItem(trabalho.getId(), trabalho.getNomeTrabalho()));
		}
	}
	
	public void gravar(){
		
	}
	
	public void limpar(){
	}

	public AlunoTrabalho getAlunoTrabalho() {
		return alunoTrabalho;
	}

	public void setAlunoTrabalho(AlunoTrabalho alunoTrabalho) {
		this.alunoTrabalho = alunoTrabalho;
	}

	public List<SelectItem> getSelectAluno() {
		return selectAluno;
	}

	public void setSelectAluno(List<SelectItem> selectAluno) {
		this.selectAluno = selectAluno;
	}

	public List<SelectItem> getSelectDisciplina() {
		return selectDisciplina;
	}

	public void setSelectDisciplina(List<SelectItem> selectDisciplina) {
		this.selectDisciplina = selectDisciplina;
	}

	public List<SelectItem> getSelectTrabalho() {
		return selectTrabalho;
	}

	public void setSelectTrabalho(List<SelectItem> selectTrabalho) {
		this.selectTrabalho = selectTrabalho;
	}

	
	
}
