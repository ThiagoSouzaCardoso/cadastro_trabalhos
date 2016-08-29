package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.AlunoDisciplinaDao;
import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.AlunoDisciplina;
import br.com.fiap.model.Disciplina;

@ManagedBean
@SessionScoped
public class NotasMB {

	private AlunoDisciplina alunoDisciplina;
	private List<Disciplina> selectDisciplina = new ArrayList<>();
	private boolean ativaBotao = true;
	private Disciplina disciplina;
	
	private List<Aluno> alunos = new ArrayList<>();
	private int alunoSelecionado;

	AlunoDao alunoDao = new AlunoDao();
	AlunoDisciplinaDao alunoDisciplinaDao = new AlunoDisciplinaDao();
	DisciplinaDao disciplinaDao = new DisciplinaDao();
	
	public NotasMB() {
		
		alunoDisciplina = new AlunoDisciplina();
		alunos.addAll(alunoDao.listar());
		
		selectDisciplina = disciplinaDao.listar();
				
		if (alunoDao.exiteDados() && disciplinaDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}
	
	public void selecionaAluno(){
		System.out.println(alunoDisciplina.getAluno().getNomeAluno());
	}
	
	public void gravar(){
		alunoDisciplina.setDisciplina(disciplina);
		alunoDisciplinaDao.adicionar(alunoDisciplina);
	}
	
	public void limpar(){
	}	

	public List<Disciplina> getSelectDisciplina() {
		return selectDisciplina;
	}

	public void setSelectDisciplina(List<Disciplina> selectDisciplina) {
		this.selectDisciplina = selectDisciplina;
	}

	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

	public boolean isAtivaBotao() {
		return ativaBotao;
	}

	public void setAtivaBotao(boolean ativaBotao) {
		this.ativaBotao = ativaBotao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(int alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}	
	
	
	
}
