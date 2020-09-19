package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Disciplina;
import br.edu.ifsc.aluno.victor.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    public void cadastrar(Disciplina disciplina) {
        disciplinaService.cadastrar(disciplina);
    }

    public void alterar(Integer id, Disciplina disciplina){
        disciplinaService.alterar(id, disciplina);
    }

    public Disciplina consultarPorId(Integer id) {
        return disciplinaService.consultar(id);
    }

    public List<Disciplina> consultar() {
        return disciplinaService.consultar();
    }

    public void deletar(Integer id) {
        disciplinaService.deletar(id);
    }
}
