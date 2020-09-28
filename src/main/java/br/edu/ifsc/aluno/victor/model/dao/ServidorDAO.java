package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.Servidor;

import java.util.List;

public interface ServidorDAO extends InterfaceDAO<Servidor> {

    Servidor findByDescricao(String nome);
    List<Servidor> findByTipo(EnumTipoServidor tipoServidor);
}
