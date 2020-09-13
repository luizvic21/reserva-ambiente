package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Usuario;

import java.util.List;

public interface UsuarioService {

    void cadastrar(Usuario usuario);
    Usuario consultar(Integer id);
    List<Usuario> consultar();
    void alterar(Integer id, Usuario usuario);
    void deletar(Integer id);
}
