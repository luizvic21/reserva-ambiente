package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Bloco;

import java.util.List;

public interface BlocoService {

    void cadastrar(Bloco bloco);
    Bloco consultar(Integer id);
    List<Bloco> consultar();
    void alterar(Integer id, Bloco bloco);
    void deletar(Integer id);
}
