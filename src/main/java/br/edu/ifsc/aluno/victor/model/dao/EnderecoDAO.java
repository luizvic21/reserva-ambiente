package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Endereco;

public interface EnderecoDAO extends InterfaceDAO<Endereco> {

    Integer createReturnId(Endereco endereco);
}
