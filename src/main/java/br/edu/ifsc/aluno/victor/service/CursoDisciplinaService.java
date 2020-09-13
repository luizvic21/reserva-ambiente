package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.CursoDisciplina;

import java.util.List;

public interface CursoDisciplinaService {

    void cadastrar(CursoDisciplina cursoDisciplina);
    CursoDisciplina consultar(Integer id);
    List<CursoDisciplina> consultar();
    void alterar(Integer id, CursoDisciplina cursoDisciplina);
    void deletar(Integer id);
}
