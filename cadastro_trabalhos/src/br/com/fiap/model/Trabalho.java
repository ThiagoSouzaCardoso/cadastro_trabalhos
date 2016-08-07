
package br.com.fiap.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trabalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="TRABALHO_ID")
	private Integer id;

	@Column(name="NOME_TRABALHO")
	private String nomeTrabalho;

	@ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
	@JoinColumn(name = "DISCIPLINA_ID")
	private Disciplina disciplina;
	
	public Trabalho() {
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeTrabalho() {
		return nomeTrabalho;
	}


	public void setNomeTrabalho(String nomeTrabalho) {
		this.nomeTrabalho = nomeTrabalho;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result
				+ ((nomeTrabalho == null) ? 0 : nomeTrabalho.hashCode());
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
		Trabalho other = (Trabalho) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (nomeTrabalho == null) {
			if (other.nomeTrabalho != null)
				return false;
		} else if (!nomeTrabalho.equals(other.nomeTrabalho))
			return false;
		return true;
	}
	
}