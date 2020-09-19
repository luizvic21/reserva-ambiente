package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Disciplina;
import br.edu.ifsc.aluno.victor.model.dao.DisciplinaDAO;
import br.edu.ifsc.aluno.victor.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
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
