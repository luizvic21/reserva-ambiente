package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.dao.EnderecoDAO;
import br.edu.ifsc.aluno.victor.service.CidadeService;
import br.edu.ifsc.aluno.victor.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoDAO enderecoDAO;

    @Autowired
    private CidadeService cidadeService;

    @Override
    public void cadastrar(Endereco endereco) {
        Cidade cidade = cidadeService.consultar(endereco.getCidade().getId());
        enderecoDAO.create(new Endereco(cidade, endereco));
    }

    @Override
    public Endereco consultar(Integer id) {
        return enderecoDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Endereco %d não encotrado", id)));
    }

    @Override
    public void alterar(Integer id, Endereco endereco) {
        Endereco enderecoAtual = consultar(id);
        Cidade cidade = cidadeService.consultar(endereco.getCidade().getId());
        enderecoDAO.update(enderecoAtual.editar(cidade, endereco));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        enderecoDAO.delete(id);
    }
}
