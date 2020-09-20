package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.Coordenador;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.model.dao.CoordenadorDAO;
import br.edu.ifsc.aluno.victor.service.CoordenadorService;
import br.edu.ifsc.aluno.victor.service.CursoService;
import br.edu.ifsc.aluno.victor.service.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorServiceImpl implements CoordenadorService {

    @Autowired
    private ServidorService servidorService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CoordenadorDAO coordenadorDAO;

    @Override
    public void cadastrar(Servidor docente, Curso curso) {
        Optional<Coordenador> coordenador = coordenadorDAO.buscarCoordenadorAtivo(curso.getId());
        if (coordenador.isPresent()) {
            desativar(curso.getId());
        }
        criarCoordenador(docente, curso);
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
    public void alterar(Servidor docente, Curso curso) {
        getCoordenadorAtivo(curso.getId());
        desativar(curso.getId());
        if (EnumTipoServidor.DOCENTE.equals(docente.getTipoServidor())) {
            criarCoordenador(docente, curso);
        }
    }

    @Override
    public void desativar(Integer cursoId) {
        Coordenador coordenadorAtual = getCoordenadorAtivo(cursoId);
        coordenadorDAO.update(coordenadorAtual.desativar());
    }

    @Override
    public Coordenador getCoordenadorAtivo(Integer cursoId) {
        return coordenadorDAO.buscarCoordenadorAtivo(cursoId).orElseThrow(() -> new RuntimeException(String.format("Coordenador não encontrado para o curso %d", cursoId)));
    }

    private void criarCoordenador(Servidor docente, Curso curso) {
        if (EnumTipoServidor.DOCENTE.equals(docente.getTipoServidor())) {
            Servidor servidor = servidorService.consultar(docente.getId());
            Curso cursoCadastrar = cursoService.consultar(curso.getId());
            Coordenador coordenador = new Coordenador(null, LocalDate.now(), null, true, docente, cursoCadastrar);
            coordenadorDAO.create(new Coordenador(servidor, curso, coordenador));
        }
    }
}
