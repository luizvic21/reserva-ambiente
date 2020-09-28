package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Disciplina;

public interface DisciplinaDAO extends InterfaceDAO<Disciplina> {

    Integer createReturnId(Disciplina disciplina);
}
