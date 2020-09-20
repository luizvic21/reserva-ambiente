package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Coordenador;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    public void cadastrar(Servidor docente, Curso curso) {
        coordenadorService.cadastrar(docente, curso);
    }

    public void alterar(Servidor docente, Curso curso){
        coordenadorService.alterar(docente, curso);
    }

    public Coordenador consultarPorId(Integer id) {
        return coordenadorService.consultar(id);
    }

    public List<Coordenador> consultar() {
        return coordenadorService.consultar();
    }

    public void desativar(Integer cursoId) {
        coordenadorService.desativar(cursoId);
    }

    public Coordenador buscarCoordenadorAtivo(Integer cursoId) {
        return coordenadorService.getCoordenadorAtivo(cursoId);
    }
}
