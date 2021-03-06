package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    public void cadastrar(Endereco endereco) {
        enderecoService.cadastrar(endereco);
    }

    public Endereco consultarPorId(Integer id) {
        return enderecoService.consultar(id);
    }

    public void alterar(Integer id, Endereco endereco) {
        enderecoService.alterar(id, endereco);
    }

    public void deletar(Integer id) {
        enderecoService.deletar(id);
    }
}
