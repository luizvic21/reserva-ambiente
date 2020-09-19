package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Ambiente;
import br.edu.ifsc.aluno.victor.service.AmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbienteController {

    @Autowired
    private AmbienteService ambienteService;

    public void cadastrar(Ambiente ambiente) {
        ambienteService.cadastrar(ambiente);
    }

    public void alterar(Integer id, Ambiente ambiente){
        ambienteService.alterar(id, ambiente);
    }

    public Ambiente consultarPorId(Integer id) {
        return ambienteService.consultar(id);
    }

    public List<Ambiente> consultar() {
        return ambienteService.consultar();
    }

    public void deletar(Integer id) {
        ambienteService.deletar(id);
    }
}
