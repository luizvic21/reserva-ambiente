package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Curso;

public interface CursoDAO extends InterfaceDAO<Curso> {

    Curso findByDescricao(String descricao);
}
