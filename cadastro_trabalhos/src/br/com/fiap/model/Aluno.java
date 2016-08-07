
package br.com.fiap.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ALUNO_ID")
	private int id;
	
	@Column(name="NOME_ALUNO")
	private String nomeAluno;
	
	@Column(name="RM_ALUNO")
	private String numeroRegistro;

	@ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
	@JoinColumn(name = "ESCOLA_ID")
	private Escola escola = new Escola();
	
	@OneToMany(mappedBy="disciplina")
	private Set<AlunoDisciplina> disciplinas;
	
	@ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
	@JoinColumn(name = "CURSO_ID")
	private Curso curso = new Curso();
	
	@OneToMany(mappedBy="aluno")
	private Set<AlunoTrabalho> trabalhos;
	
	public Aluno() {
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno(int id, String nomeAluno) {
		this.id = id;
		this.nomeAluno = nomeAluno;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return this.nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Set<AlunoDisciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<AlunoDisciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public Set<AlunoTrabalho> getTrabalhos() {
		return trabalhos;
	}

	public void setTrabalhos(Set<AlunoTrabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((escola == null) ? 0 : escola.hashCode());
		result = prime * result
				+ ((nomeAluno == null) ? 0 : nomeAluno.hashCode());
		result = prime * result
				+ ((numeroRegistro == null) ? 0 : numeroRegistro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (escola == null) {
			if (other.escola != null)
				return false;
		} else if (!escola.equals(other.escola))
			return false;
		if (nomeAluno == null) {
			if (other.nomeAluno != null)
				return false;
		} else if (!nomeAluno.equals(other.nomeAluno))
			return false;
		if (numeroRegistro == null) {
			if (other.numeroRegistro != null)
				return false;
		} else if (!numeroRegistro.equals(other.numeroRegistro))
			return false;
		return true;
	}
	
}