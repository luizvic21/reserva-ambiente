package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.dao.CidadeDAO;
import br.edu.ifsc.aluno.victor.model.dao.jdbc.CidadeDAOJdbc;
import br.edu.ifsc.aluno.victor.service.CidadeService;
import br.edu.ifsc.aluno.victor.service.impl.CidadeServiceImpl;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController() {
        CidadeDAO cidadeDAO = new CidadeDAOJdbc();
        cidadeService = new CidadeServiceImpl(cidadeDAO);
    }

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
