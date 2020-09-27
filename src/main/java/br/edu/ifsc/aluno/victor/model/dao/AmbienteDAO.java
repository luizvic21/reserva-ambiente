package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Ambiente;

import java.util.List;

public interface AmbienteDAO extends InterfaceDAO<Ambiente> {
    List<Ambiente> findByBlocoId(Integer blocoId);
}
