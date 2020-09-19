package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
