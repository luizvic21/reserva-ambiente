package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.dao.CursoDAO;
import br.edu.ifsc.aluno.victor.service.CursoService;

import java.util.List;

public class CursoServiceImpl implements CursoService {

    private CursoDAO cursoDAO;

    @Override
    public void cadastrar(Curso curso) {
        cursoDAO.create(curso);
    }

    @Override
    public Curso consultar(Integer id) {
        return cursoDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Curso %d não encontrada", id)));
    }

    @Override
    public List<Curso> consultar() {
        return cursoDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Curso curso) {
        Curso cursoAtual = consultar(id);
        cursoDAO.update(cursoAtual.editar(curso));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        cursoDAO.delete(id);
    }
}
