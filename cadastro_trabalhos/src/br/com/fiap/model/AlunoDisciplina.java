package br.com.fiap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;
	
	public AlunoDisciplina() {
		 setStatus(Status.CURSANDO);
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
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