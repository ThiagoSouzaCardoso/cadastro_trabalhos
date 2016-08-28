package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.AlunoDisciplina;
import br.com.fiap.model.Disciplina;

@ManagedBean
@RequestScoped
public class NotasMB {

	private AlunoDisciplina alunoDisciplina;
	private List<SelectItem> selectAluno = new ArrayList<SelectItem>();
	private List<SelectItem> selectDisciplina = new ArrayList<SelectItem>();
	private boolean ativaBotao = true;
	
	private List<Aluno> alunos = new ArrayList<>();
	private int alunoSelecionado;

	AlunoDao alunoDao = new AlunoDao();
	DisciplinaDao disciplinaDao = new DisciplinaDao();
	
	public NotasMB() {
		
		alunoDisciplina = new AlunoDisciplina();
		alunos.addAll(alunoDao.listar());
		
		for(Aluno aluno:alunoDao.listar()){
			selectAluno.add(new SelectItem(aluno.getId(), aluno.getNomeAluno()));
		}
		
		for(Disciplina disciplina:disciplinaDao.listar()){
			selectAluno.add(new SelectItem(disciplina.getId(), disciplina.getNomeDisciplina()));
		}
				
		if (alunoDao.exiteDados() && disciplinaDao.exiteDados()) {
			ativaBotao = true;
		} else {
			ativaBotao = false;
		}
	}
	
	public void gravar(){
		
	}
	
	public void limpar(){
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
	
	
	
}
