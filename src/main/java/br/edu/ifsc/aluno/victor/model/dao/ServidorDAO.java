package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Servidor;

public interface ServidorDAO extends InterfaceDAO<Servidor> {

    Servidor findByDescricao(String nome);
}
