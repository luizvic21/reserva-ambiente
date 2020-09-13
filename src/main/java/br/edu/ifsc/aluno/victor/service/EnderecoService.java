package br.edu.ifsc.aluno.victor.service;


import br.edu.ifsc.aluno.victor.model.Endereco;

import java.util.List;

public interface EnderecoService {

    void cadastrar(Endereco endereco);
    Endereco consultar(Integer id);
    void alterar(Integer id, Endereco endereco);
    void deletar(Integer id);
}
