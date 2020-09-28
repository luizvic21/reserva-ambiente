package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Cidade;

public interface CidadeDAO extends InterfaceDAO<Cidade> {

    Cidade findByDescricao(String descricao);

}
