
package br.com.fiap.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Disciplina implements Serializable,BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="DISCIPLINA_ID")
	private int id;

	@Column(name="NOME_DISCIPLINA")
	private String nomeDisciplina;

	@OneToMany(mappedBy="aluno",fetch = FetchType.EAGER)
	private Set<AlunoDisciplina> alunos;
	
	@ManyToMany(mappedBy="disciplinas",fetch = FetchType.EAGER,cascade={MERGE})
	private Set<Curso> cursos = new HashSet<Curso>();

	public Disciplina() {
		
	}

	public Set<AlunoDisciplina> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<AlunoDisciplina> alunos) {
		this.alunos = alunos;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (nomeDisciplina == null) {
			if (other.nomeDisciplina != null)
				return false;
		} else if (!nomeDisciplina.equals(other.nomeDisciplina))
			return false;
		return true;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

}