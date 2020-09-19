package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.CursoDisciplina;
import br.edu.ifsc.aluno.victor.service.CursoDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoDisciplinaController {

    @Autowired
    private CursoDisciplinaService cursoDisciplinaService;

    public void cadastrar(CursoDisciplina cursoDisciplina) {
        cursoDisciplinaService.cadastrar(cursoDisciplina);
    }

    public void alterar(Integer id, CursoDisciplina cursoDisciplina){
        cursoDisciplinaService.alterar(id, cursoDisciplina);
    }

    public CursoDisciplina consultarPorId(Integer id) {
        return cursoDisciplinaService.consultar(id);
    }

    public List<CursoDisciplina> consultar() {
        return cursoDisciplinaService.consultar();
    }

    public void deletar(Integer id) {
        cursoDisciplinaService.deletar(id);
    }
}
