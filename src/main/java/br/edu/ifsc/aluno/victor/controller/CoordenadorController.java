package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Coordenador;
import br.edu.ifsc.aluno.victor.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    public void cadastrar(Coordenador coordenador) {
        coordenadorService.cadastrar(coordenador);
    }

    public void alterar(Integer id, Coordenador coordenador){
        coordenadorService.alterar(id, coordenador);
    }

    public Coordenador consultarPorId(Integer id) {
        return coordenadorService.consultar(id);
    }

    public List<Coordenador> consultar() {
        return coordenadorService.consultar();
    }

    public void deletar(Integer id) {
        coordenadorService.deletar(id);
    }
}
