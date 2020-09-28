package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Servidor;

import java.util.List;

public interface ServidorService {

    void cadastrar(Servidor servidor);
    Servidor consultar(Integer id);
    List<Servidor> consultar();
    void alterar(Integer id, Servidor servidor);
    void deletar(Integer id);
    Servidor consultar(String Nome);
}
