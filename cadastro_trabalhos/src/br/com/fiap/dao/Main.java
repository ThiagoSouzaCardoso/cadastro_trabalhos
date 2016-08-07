package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Curso;
import br.com.fiap.model.Escola;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Curso curso = new Curso();
		curso.setNomeCurso("teste Curso");

		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(curso);
		
		Escola escola = new Escola();
		escola.setNomeEscola("teste Escola");
		escola.setCursos(cursos);
		
		EscolaDao dao = new EscolaDao();
		dao.adicionar(escola);
	}

}
