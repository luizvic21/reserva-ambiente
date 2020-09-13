package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.Usuario;
import br.edu.ifsc.aluno.victor.model.dao.UsuarioDAO;
import br.edu.ifsc.aluno.victor.service.EnderecoService;
import br.edu.ifsc.aluno.victor.service.UsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private EnderecoService enderecoService;
    private UsuarioDAO usuarioDAO;

    @Override
    public void cadastrar(Usuario usuario) {
        Endereco endereco = enderecoService.consultar(usuario.getEndereco().getId());
        usuarioDAO.create(new Usuario(endereco, usuario));
    }

    @Override
    public Usuario consultar(Integer id) {
        return usuarioDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Usuario %d não encontrada", id)));
    }

    @Override
    public List<Usuario> consultar() {
        return usuarioDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Usuario usuario) {
        Endereco endereco = enderecoService.consultar(usuario.getEndereco().getId());
        Usuario usuarioAtual = consultar(id);
        usuarioDAO.create(usuarioAtual.editar(endereco, usuario));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        usuarioDAO.delete(id);
    }
}
