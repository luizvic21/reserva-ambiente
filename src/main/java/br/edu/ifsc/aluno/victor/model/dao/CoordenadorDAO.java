package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Coordenador;

import java.util.Optional;

public interface CoordenadorDAO extends InterfaceDAO<Coordenador> {

    Optional<Coordenador> buscarCoordenadorAtivo(Integer cursoId);
}
