package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    public void cadastrar(Cidade cidade) {
        cidadeService.cadastrar(cidade);
    }

    public void alterar(Integer id, Cidade cidade){
        cidadeService.alterar(id, cidade);
    }

    public Cidade consultarPorId(Integer id) {
        return cidadeService.consultar(id);
    }

    public List<Cidade> consultar() {
        return cidadeService.consultar();
    }

    public void deletar(Integer id) {
        cidadeService.deletar(id);
    }

    public Cidade consultarPorDescricao(String descricao) {
        return cidadeService.consultar(descricao);
    };
}
