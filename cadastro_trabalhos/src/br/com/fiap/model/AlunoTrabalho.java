package br.com.fiap.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;


@Entity
@Table(name = "aluno_trabalho")
public class AlunoTrabalho  implements Serializable{

	private static final long serialVersionUID = 7871933887506541652L;
	
	@EmbeddedId
	private AlunoTrabalhoId id = new AlunoTrabalhoId();
	
	@ManyToOne
	@JoinColumn(name = "ALUNO_ID", referencedColumnName = "ALUNO_ID",insertable=false,updatable=false)
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "TRABALHO_ID", referencedColumnName = "TRABALHO_ID",insertable=false,updatable=false)
	private Trabalho trabalho;

	@ManyToOne
	@JoinColumn(name = "DISCIPLINA_ID", referencedColumnName = "DISCIPLINA_ID",insertable=false,updatable=false)
	private Disciplina disciplina;
	
	@Column(name="nota")
	@Digits(integer=10,fraction=2)
	private BigDecimal nota;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	

	public AlunoTrabalhoId getId() {
		return id;
	}

	public void setId(AlunoTrabalhoId id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result
				+ ((trabalho == null) ? 0 : trabalho.hashCode());
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
		AlunoTrabalho other = (AlunoTrabalho) obj;
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
		if (trabalho == null) {
			if (other.trabalho != null)
				return false;
		} else if (!trabalho.equals(other.trabalho))
			return false;
		return true;
	}
	
}