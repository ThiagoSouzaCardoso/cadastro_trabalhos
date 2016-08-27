package br.com.fiap.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "aluno_disciplina")
public class AlunoDisciplina implements Serializable{

	private static final long serialVersionUID = -9169547308297705946L;

	@EmbeddedId
	private AlunoDisciplinaId id = new AlunoDisciplinaId();
	
	@ManyToOne
	@JoinColumn(name = "ALUNO_ID", referencedColumnName = "ALUNO_ID",insertable=false,updatable=false)
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "DISCIPLINA_ID", referencedColumnName = "DISCIPLINA_ID",insertable=false,updatable=false)
	private Disciplina disciplina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROFESSOR_ID",referencedColumnName="PROFESSOR_ID",insertable=false,updatable=false)
	private Professor professor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CURSO_ID",referencedColumnName="CURSO_ID",insertable=false,updatable=false)
	private Curso curso;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;
	
	@Column(name="projeto1")
	@Digits(integer=10,fraction=2)
	private BigDecimal projeto1;
	
	@Column(name="projeto2")
	@Digits(integer=10,fraction=2)
	private BigDecimal projeto2;
	
	@Column(name="atividade")
	@Digits(integer=10,fraction=2)
	private BigDecimal atividade;
	
	public AlunoDisciplina() {
		 setStatus(Status.CURSANDO);
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.id.setIdAluno(aluno.getId());
		this.aluno = aluno;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.id.setIdDisciplina(disciplina.getId());
		this.disciplina = disciplina;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(BigDecimal projeto1) {
		this.projeto1 = projeto1;
	}

	public BigDecimal getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(BigDecimal projeto2) {
		this.projeto2 = projeto2;
	}

	public BigDecimal getAtividade() {
		return atividade;
	}

	public void setAtividade(BigDecimal atividade) {
		this.atividade = atividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
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
		AlunoDisciplina other = (AlunoDisciplina) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		return true;
	}

	
}