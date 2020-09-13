package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.CursoDisciplina;
import br.edu.ifsc.aluno.victor.model.Disciplina;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.model.dao.CursoDisciplinaDAO;
import br.edu.ifsc.aluno.victor.service.CursoDisciplinaService;
import br.edu.ifsc.aluno.victor.service.CursoService;
import br.edu.ifsc.aluno.victor.service.DisciplinaService;
import br.edu.ifsc.aluno.victor.service.ServidorService;

import java.util.List;

public class CursoDisciplinaServiceImpl implements CursoDisciplinaService {

    private CursoService cursoService;
    private DisciplinaService disciplinaService;
    private ServidorService servidorService;
    private CursoDisciplinaDAO cursoDisciplinaDAO;

    @Override
    public void cadastrar(CursoDisciplina cursoDisciplina) {
        Curso curso = cursoService.consultar(cursoDisciplina.getCurso().getId());
        Disciplina disciplina = disciplinaService.consultar(cursoDisciplina.getDisciplina().getId());
        Servidor docente = servidorService.consultar(cursoDisciplina.getDocente().getId());
        cursoDisciplinaDAO.create(new CursoDisciplina(docente, curso, disciplina, cursoDisciplina));
    }

    @Override
    public CursoDisciplina consultar(Integer id) {
        return cursoDisciplinaDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("CursoDisciplina %d não encontrada", id)));
    }

    @Override
    public List<CursoDisciplina> consultar() {
        return cursoDisciplinaDAO.findAll();
    }

    @Override
    public void alterar(Integer id, CursoDisciplina cursoDisciplina) {
        Curso curso = cursoService.consultar(cursoDisciplina.getCurso().getId());
        Disciplina disciplina = disciplinaService.consultar(cursoDisciplina.getDisciplina().getId());
        Servidor docente = servidorService.consultar(cursoDisciplina.getDocente().getId());
        CursoDisciplina cursoDisciplinaAtual = consultar(id);
        cursoDisciplinaDAO.create(cursoDisciplinaAtual.editar(docente, curso, disciplina, cursoDisciplina));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        cursoDisciplinaDAO.delete(id);
    }
}
