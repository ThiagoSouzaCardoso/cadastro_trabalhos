package br.com.fiap.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Escola  implements Serializable{

	private static final long serialVersionUID = -5786857402392306665L;
	
	@Id
	@GeneratedValue
	@Column(name="ESCOLA_ID")
	private Integer id;
	
	@Column(name="NOME_ESCOLA")
	private String nomeEscola;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "escola_curso",joinColumns = {@JoinColumn (name = "ESCOLA_ID", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "CURSO_ID",nullable = false, updatable = false) })
	private List<Curso> cursos;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "escola_professor",joinColumns = {@JoinColumn (name = "ESCOLA_ID", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "PROFESSOR_ID",nullable = false, updatable = false) })
	private List<Professor> professores;
	
	@OneToMany(mappedBy="escola",fetch = FetchType.EAGER)
	private Set<Aluno> alunos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeEscola == null) ? 0 : nomeEscola.hashCode());
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
		Escola other = (Escola) obj;
		if (nomeEscola == null) {
			if (other.nomeEscola != null)
				return false;
		} else if (!nomeEscola.equals(other.nomeEscola))
			return false;
		return true;
	}
	
}