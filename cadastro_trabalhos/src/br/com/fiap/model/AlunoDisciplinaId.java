package br.com.fiap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlunoDisciplinaId implements Serializable{

	private static final long serialVersionUID = 6141082385886261082L;

	@Column(name="ALUNO_ID",insertable=false,updatable=false)
	private Integer idAluno;
	
	@Column(name="DISCIPLINA_ID",insertable=false,updatable=false)
	private Integer idDisciplina;
	
	public AlunoDisciplinaId() {

	}

	public AlunoDisciplinaId(Integer idAluno, Integer idDisciplina) {
		super();
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
	}



	public Integer getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}
	public Integer getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		result = prime * result
				+ ((idDisciplina == null) ? 0 : idDisciplina.hashCode());
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
		AlunoDisciplinaId other = (AlunoDisciplinaId) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		if (idDisciplina == null) {
			if (other.idDisciplina != null)
				return false;
		} else if (!idDisciplina.equals(other.idDisciplina))
			return false;
		return true;
	}
	
}