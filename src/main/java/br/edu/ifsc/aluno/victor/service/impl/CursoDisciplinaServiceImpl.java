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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoDisciplinaServiceImpl implements CursoDisciplinaService {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private ServidorService servidorService;

    @Autowired
    private CursoDisciplinaDAO cursoDisciplinaDAO;

    @Override
    public void cadastrar(CursoDisciplina cursoDisciplina) {
        Curso curso = cursoService.consultar(cursoDisciplina.getCurso().getId());
        Integer idDisciplina = disciplinaService.cadastrarRetornandoId(cursoDisciplina.getDisciplina());
        Disciplina disciplina = disciplinaService.consultar(idDisciplina);
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
        CursoDisciplina cursoDisciplinaAtual = consultar(id);
        disciplinaService.alterar(cursoDisciplinaAtual.getDisciplina().getId(), cursoDisciplina.getDisciplina());
        Curso curso = cursoService.consultar(cursoDisciplina.getCurso().getId());
        Servidor docente = servidorService.consultar(cursoDisciplina.getDocente().getId());
        Disciplina disciplina = disciplinaService.consultar(cursoDisciplinaAtual.getDisciplina().getId());
        cursoDisciplinaDAO.update(cursoDisciplinaAtual.editar(docente, curso, disciplina, cursoDisciplina));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        cursoDisciplinaDAO.delete(id);
    }
}
