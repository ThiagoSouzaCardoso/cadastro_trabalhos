package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.EscolaDao;
import br.com.fiap.model.Escola;

@ManagedBean
@RequestScoped
public class EscolaMB {

	private Escola escola;
	EscolaDao dao = new EscolaDao();
	
	public EscolaMB() {
		// TODO Auto-generated constructor stub
	}

	public void gravar() {
		dao.adicionar(escola);
	}

	public void limpar() {

	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	
}
