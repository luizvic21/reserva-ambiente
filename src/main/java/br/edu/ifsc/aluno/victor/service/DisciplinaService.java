package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Disciplina;

import java.util.List;

public interface DisciplinaService {

    void cadastrar(Disciplina disciplina);
    Disciplina consultar(Integer id);
    List<Disciplina> consultar();
    void alterar(Integer id, Disciplina disciplina);
    void deletar(Integer id);
    Integer cadastrarRetornandoId(Disciplina disciplina);
}
