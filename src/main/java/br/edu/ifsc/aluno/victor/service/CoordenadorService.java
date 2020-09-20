package br.edu.ifsc.aluno.victor.service;

import br.edu.ifsc.aluno.victor.model.Coordenador;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.Servidor;

import java.util.List;

public interface CoordenadorService {

    void cadastrar(Servidor docente, Curso curso);
    Coordenador consultar(Integer id);
    List<Coordenador> consultar();
    void alterar(Servidor docente, Curso curso);
    void desativar(Integer cursoId);
    Coordenador getCoordenadorAtivo(Integer cursoId);
}
