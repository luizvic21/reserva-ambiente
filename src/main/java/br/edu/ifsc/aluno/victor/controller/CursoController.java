package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoController {

    @Autowired
    private CursoService cursoService;

    public void cadastrar(Curso curso) {
        cursoService.cadastrar(curso);
    }

    public void alterar(Integer id, Curso curso){
        cursoService.alterar(id, curso);
    }

    public Curso consultarPorId(Integer id) {
        return cursoService.consultar(id);
    }

    public List<Curso> consultar() {
        return cursoService.consultar();
    }

    public void deletar(Integer id) {
        cursoService.deletar(id);
    }
}
