package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Bloco;
import br.edu.ifsc.aluno.victor.service.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocoController {

    @Autowired
    private BlocoService blocoService;

    public void cadastrar(Bloco bloco) {
        blocoService.cadastrar(bloco);
    }

    public void alterar(Integer id, Bloco bloco){
        blocoService.alterar(id, bloco);
    }

    public Bloco consultarPorId(Integer id) {
        return blocoService.consultar(id);
    }

    public List<Bloco> consultar() {
        return blocoService.consultar();
    }

    public void deletar(Integer id) {
        blocoService.deletar(id);
    }

    public Bloco consultarPorDescricao(String descricao) {
        return blocoService.consultar(descricao);
    };
}
