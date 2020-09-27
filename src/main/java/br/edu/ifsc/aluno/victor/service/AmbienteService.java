package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Ambiente;

import java.util.List;

public interface AmbienteService {

    void cadastrar(Ambiente ambiente);
    Ambiente consultar(Integer id);
    List<Ambiente> consultar();
    void alterar(Integer id, Ambiente ambiente);
    void deletar(Integer id);
    List<Ambiente> consultarPorBlocoId(Integer blocoId);
}
