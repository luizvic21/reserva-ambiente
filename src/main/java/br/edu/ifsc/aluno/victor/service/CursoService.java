package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Curso;

import java.util.List;

public interface CursoService {

    void cadastrar(Curso curso);
    Curso consultar(Integer id);
    List<Curso> consultar();
    void alterar(Integer id, Curso curso);
    void deletar(Integer id);
}
