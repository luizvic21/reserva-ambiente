package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Usuario;
import br.edu.ifsc.aluno.victor.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioController  {

    @Autowired
    private UsuarioService usuarioService;

    public void cadastrar(Usuario usuario) {
        usuarioService.cadastrar(usuario);
    }

    public void alterar(Integer id, Usuario usuario){
        usuarioService.alterar(id, usuario);
    }

    public Usuario consultarPorId(Integer id) {
        return usuarioService.consultar(id);
    }

    public List<Usuario> consultar() {
        return usuarioService.consultar();
    }

    public void deletar(Integer id) {
        usuarioService.deletar(id);
    }

    public boolean logar(String username, String senha) {
        return usuarioService.logar(username, senha);
    }
}
