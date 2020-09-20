package br.edu.ifsc.aluno.victor.model.dao;

import br.edu.ifsc.aluno.victor.model.Usuario;

import java.util.Optional;

public interface UsuarioDAO extends InterfaceDAO<Usuario> {

    Optional<Usuario> logar(String username, String senha);
}
