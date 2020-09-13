package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Coordenador;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.model.dao.CoordenadorDAO;
import br.edu.ifsc.aluno.victor.service.CoordenadorService;
import br.edu.ifsc.aluno.victor.service.CursoService;
import br.edu.ifsc.aluno.victor.service.ServidorService;

import java.util.List;

public class CoordenadorServiceImpl implements CoordenadorService {

    private ServidorService servidorService;
    private CursoService cursoService;
    private CoordenadorDAO coordenadorDAO;

    @Override
    public void cadastrar(Coordenador coordenador) {
        Servidor servidor = servidorService.consultar(coordenador.getServidor().getId());
        Curso curso = cursoService.consultar(coordenador.getCurso().getId());
        coordenadorDAO.create(new Coordenador(servidor, curso, coordenador));
    }

    @Override
    public Coordenador consultar(Integer id) {
        return coordenadorDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Coordenador %d não encontrada", id)));
    }

    @Override
    public List<Coordenador> consultar() {
        return coordenadorDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Coordenador coordenador) {
        Servidor servidor = servidorService.consultar(coordenador.getServidor().getId());
        Curso curso = cursoService.consultar(coordenador.getCurso().getId());
        Coordenador coordenadorAtual = consultar(id);
        coordenadorDAO.update(coordenadorAtual.editar(servidor, curso, coordenador));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        coordenadorDAO.delete(id);
    }
}
