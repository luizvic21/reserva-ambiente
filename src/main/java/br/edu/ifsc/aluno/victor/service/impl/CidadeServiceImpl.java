package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.dao.CidadeDAO;
import br.edu.ifsc.aluno.victor.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeDAO cidadeDAO;

    @Override
    public void cadastrar(Cidade cidade) {
        cidadeDAO.create(cidade);
    }

    @Override
    public Cidade consultar(Integer id) {
        return cidadeDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cidade %d não encontrada", id)));
    }

    @Override
    public List<Cidade> consultar() {
        return cidadeDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Cidade cidade) {
        Cidade cidadeAtual = consultar(id);
        cidadeDAO.update(cidadeAtual.alterar(cidade));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        cidadeDAO.delete(id);
    }
}
