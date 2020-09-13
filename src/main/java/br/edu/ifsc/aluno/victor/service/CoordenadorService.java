package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Coordenador;

import java.util.List;

public interface CoordenadorService {

    void cadastrar(Coordenador coordenador);
    Coordenador consultar(Integer id);
    List<Coordenador> consultar();
    void alterar(Integer id, Coordenador coordenador);
    void deletar(Integer id);
}
