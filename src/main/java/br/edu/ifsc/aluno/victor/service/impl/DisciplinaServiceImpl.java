package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Disciplina;
import br.edu.ifsc.aluno.victor.model.dao.DisciplinaDAO;
import br.edu.ifsc.aluno.victor.service.DisciplinaService;

import java.util.List;

public class DisciplinaServiceImpl implements DisciplinaService {

    private DisciplinaDAO disciplinaDAO;

    @Override
    public void cadastrar(Disciplina disciplina) {
        disciplinaDAO.create(disciplina);
    }

    @Override
    public Disciplina consultar(Integer id) {
        return disciplinaDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Disciplina %d não encontrada", id)));
    }

    @Override
    public List<Disciplina> consultar() {
        return disciplinaDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Disciplina disciplina) {
        Disciplina disciplinaAtual = consultar(id);
        disciplinaDAO.update(disciplinaAtual.editar(disciplina));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        disciplinaDAO.delete(id);
    }
}
