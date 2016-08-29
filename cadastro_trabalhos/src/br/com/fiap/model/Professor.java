package br.com.fiap.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable,BaseEntity{

	private static final long serialVersionUID = 4592669127109906980L;

	@Id
    @GeneratedValue
    @Column(name="PROFESSOR_ID")
	private Integer id;
	
	@Column(name="NOME_PROFESSOR")
	private String nomeProfessor;
	
	@ManyToMany(mappedBy="professores",fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	private Set<Escola> escolas = new HashSet<>();
	
	public Professor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Set<Escola> getEscolas() {
		return escolas;
	}


	public void setEscolas(Set<Escola> escolas) {
		this.escolas = escolas;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	
}
