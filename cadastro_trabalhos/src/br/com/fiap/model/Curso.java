
package br.com.fiap.model;

import java.io.Serializable;
import java.util.HashSet;
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
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="CURSO_ID")
	private Integer id;

	@Column(name="NOME_CURSO")
	private String nomeCurso;
	
	@ManyToMany(mappedBy="cursos",fetch = FetchType.EAGER)
	private Set<Escola> escolas = new HashSet<Escola>(0);
	
	@OneToMany(mappedBy="curso",fetch = FetchType.EAGER)
	private Set<Aluno> alunos = new HashSet<Aluno>(0);
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "curso_disciplina",joinColumns = {@JoinColumn (name = "CURSO_ID", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "DISCIPLINA_ID",nullable = false, updatable = false) })
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>(0);
	
	public Set<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(Set<Escola> escolas) {
		this.escolas = escolas;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setIdcurso(Integer id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return this.nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeCurso == null) ? 0 : nomeCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (nomeCurso == null) {
			if (other.nomeCurso != null)
				return false;
		} else if (!nomeCurso.equals(other.nomeCurso))
			return false;
		return true;
	}
	
}