package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Cidade;

import java.util.List;

public interface CidadeService {

    void cadastrar(Cidade cidade);
    Cidade consultar(Integer id);
    List<Cidade> consultar();
    void alterar(Integer id, Cidade cidade);
    void deletar(Integer id);
    Cidade consultar(String descricao);
}
